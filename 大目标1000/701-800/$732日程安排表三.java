/**
 * 输入：
 * ["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * 输出：
 * [null, 1, 1, 2, 3, 3, 3]
 *
 * 解释：
 * MyCalendarThree myCalendarThree = new MyCalendarThree();
 * myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
 * myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
 * myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
 * myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
 * myCalendarThree.book(5, 10); // 返回 3
 * myCalendarThree.book(25, 55); // 返回 3
 *
 */
public class $732日程安排表三 {

    public static void main(String[] args) {
        MyCalendarThree c = new MyCalendarThree();
        System.out.println(c.book(10,20));
        System.out.println(c.book(50,60));
        System.out.println(c.book(10,40));
        System.out.println(c.book(5,15));
        System.out.println(c.book(5,10));
        System.out.println(c.book(25,55));
    }
}

class MyCalendarThree {
    class Node {
        private int left;
        private int right;
        private int max;
        private int lazy;
        Node leftChild, rightChild;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    private Node root;

    public MyCalendarThree() {
        root = new Node(0, (int) 1e9);
    }
    public int book(int start, int end) {
        update(root, start, end-1, 1);
        return root.max;
    }

    public void update(Node root, int left, int right, int value) {
        if (root.left>right || root.right<left) {
            return;
        }
        if (root.left>=left && root.right<=right) {
            root.max += value;
            root.lazy += value;
        }else {
            // 动态开点
            lazyCreate(root);
            // 下传lazy
            pushDown(root);
            // 更新左子树
            update(root.leftChild, left, right, value);
            // 更新右子树
            update(root.rightChild, left, right, value);
            // 上传结果
            pushUp(root);
        }

    }
    public void lazyCreate(Node root) {
        if (root.leftChild==null) {
            root.leftChild = new Node(root.left, root.left+(root.right-root.left)/2);
        }
        if (root.rightChild==null) {
            root.rightChild = new Node(root.left+(root.right-root.left)/2+1, root.right);
        }
    }
    public void pushDown(Node root) {
        if (root.lazy > 0) {
            root.leftChild.max += root.lazy;
            root.leftChild.lazy += root.lazy;
            root.rightChild.max += root.lazy;
            root.rightChild.lazy += root.lazy;
            root.lazy = 0;
        }
    }
    public void pushUp(Node root) {
        root.max = Math.max(root.leftChild.max, root.rightChild.max);
    }
}
