/**
 * 输入
 * ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
 * [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
 * 输出
 * [null, null, null, true, false, true]
 *
 * 解释
 * RangeModule rangeModule = new RangeModule();
 * rangeModule.addRange(10, 20);
 * rangeModule.removeRange(14, 16);
 * rangeModule.queryRange(10, 14); 返回 true （区间 [10, 14) 中的每个数都正在被跟踪）
 * rangeModule.queryRange(13, 15); 返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
 * rangeModule.queryRange(16, 17); 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
 *
 */
public class $715range模块 {

    public static void main(String[] args) {
        RangeModule obj = new RangeModule();
        obj.addRange(10, 20);
        obj.removeRange(14, 16);
        System.out.println(obj.queryRange(10, 14));
        System.out.println(obj.queryRange(13, 15));
        System.out.println(obj.queryRange(16, 17));
    }
}

/**
 * 设计一个数据结构来跟踪表示为半开区间的范围并查询它们。半开区间[left, right)表示所有left<=x<right的实数x
 */
class RangeModule {
    // 线段树的结点
    static class Node {
        //左范围
        private int leftX;
        //右范围
        private int rightX;
        //区间和
        private int sum;
        //懒标记 0表示删除 1表示添加 2表示无懒更新
        private int lazy;
        //左子树和右子树
        Node leftChild, rightChild;
        public Node(int leftX, int rightX) {
            this.leftX = leftX;
            this.rightX = rightX;
        }
    }
    private Node root;

    /**
     * 区间更新
     * @param root  树的根
     * @param left  左边界
     * @param right 右边界
     * @param value 更新值,删除则相当于置为0
     */
    public void update(Node root, int left, int right, int value) {
        //不在范围内 直接返回
        if (root.leftX > right || root.rightX < left) {
            return;
        }
        //修改的区间包含当前结点
        if (root.leftX >= left && root.rightX <= right) {
            root.lazy = value;
            root.sum = (root.rightX - root.leftX + 1) * value;
        } else {
            //动态开点
            lazyCreate(root);
            //下传lazy
            pushDown(root);
            //更新左子树
            update(root.leftChild, left, right, value);
            //更新右子树
            update(root.rightChild, left, right, value);
            //上传结果
            pushUp(root);
        }
    }
    public int query(Node root, int left, int right) {
        if (left <= root.leftX && root.rightX <= right) {
            return root.sum;
        }
        lazyCreate(root);
        pushDown(root);
        int mid = root.leftX + (root.rightX - root.leftX) / 2;
        if (right <= mid) {
            return query(root.leftChild, left, right);
        } else if (left > mid) {
            return query(root.rightChild, left, right);
        } else {
            return query(root.leftChild, left, mid) + query(root.rightChild, mid + 1, right);
        }
    }
    /**
     * 创建左右子树
     * @param root
     */
    public void lazyCreate(Node root) {
        if (root.leftChild == null) {
            root.leftChild = new Node(root.leftX, root.leftX + (root.rightX - root.leftX) / 2);
        }
        if (root.rightChild == null) {
            root.rightChild = new Node(root.leftX + (root.rightX - root.leftX) / 2 + 1, root.rightX);
        }
    }
    /**
     * 下传lazy
     * @param root
     */
    public void pushDown(Node root) {
        if (root.lazy == 2) {
            return;
        }
        int value = root.lazy;
        root.leftChild.lazy = value;
        root.rightChild.lazy = value;
        root.leftChild.sum = (root.leftChild.rightX - root.leftChild.leftX + 1) * value;
        root.rightChild.sum = (root.rightChild.rightX - root.rightChild.leftX + 1) * value;
        root.lazy = 2;
    }
    /**
     * 上传结果
     * @param root
     */
    public void pushUp(Node root) {
        root.sum = root.leftChild.sum + root.rightChild.sum;
    }

    public RangeModule() {
        root = new Node(0, (int) (1e9));
    }
    // 添加半开区间[left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。
    public void addRange(int left, int right) {
        update(root, left, right - 1, 1);
    }
    // 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true ，否则返回 false 。
    public boolean queryRange(int left, int right) {
        return (right - left) == query(root, left, right - 1);
    }
    // 停止跟踪 半开区间 [left, right) 中当前正在跟踪的每个实数。
    public void removeRange(int left, int right) {
        update(root, left, right - 1, 0);
    }
}