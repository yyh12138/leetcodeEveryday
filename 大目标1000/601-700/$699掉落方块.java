import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入: [[1, 2], [2, 3], [6, 1]]
 * 输出: [2, 5, 5]
 * 解释:
 * 第一个方块 positions[0] = [1, 2] 掉落：
 * _aa
 * _aa
 * -------
 * 方块最大高度为 2 。
 * 第二个方块 positions[1] = [2, 3] 掉落：
 * __aaa
 * __aaa
 * __aaa
 * _aa__
 * _aa__
 * --------------
 * 方块最大高度为5。
 * 大的方块保持在较小的方块的顶部，不论它的重心在哪里，因为方块的底部边缘有非常大的粘性。
 * 第三个方块 positions[1] = [6, 1] 掉落：
 * __aaa
 * __aaa
 * __aaa
 * _aa
 * _aa___a
 * --------------
 * 方块最大高度为5。
 * 因此，我们返回结果[2, 5, 5]。
 */
public class $699掉落方块 {
    // 遍历
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int max = 0;
        int n = positions.length;
        int[] height = new int[n];
        for(int i=0;i<n;++i){
            int l = positions[i][0];
            int h = positions[i][1];
            int r =l + h;
            height[i] = h;
            for(int j=0;j<i;++j){
                int ll = positions[j][0];
                int rr = positions[j][0] + positions[j][1];
                int hh = height[j];
                //judge if overlap
                if((ll<=l && l<rr) || (ll<r && r <=rr) || (l<=ll && r >=rr)) {
                    height[i] = Math.max(height[j] + h,height[i]);
                }
            }
            max = Math.max(max,height[i]);
            res.add(max);
        }
        return res;
    }
    /**
     * 动态开点线段树
     * 1、线段树用于维护值域
     * 2、为了降低空间复杂度，在最初只建立一个根节点，代表整个区间。当需要访问线段树的某棵子树(某个子区间)时，再建立代表这个子区间的节点
     */
    // 线段树中节点
    class Node {
        //左范围
        private final int leftX;
        //右范围
        private final int rightX;
        //最大高度
        private final int maxHeight;
        //右边界
        private int maxR;
        //左子树和右子树
        Node leftChild, rightChild;
        public Node(int leftX, int rightX, int height, int maxR) {
            this.leftX = leftX;
            this.rightX = rightX;
            this.maxHeight = height;
            this.maxR = maxR;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public List<Integer> fallingSquares2(int[][] positions) {
        //创建返回值
        List<Integer> res = new ArrayList<>();
        //根节点，默认为零
        Node root = null;
        //目前最高的高度
        int curMax = 0;
        for (int[] position : positions) {
            //左坐标
            int left = position[0];
            //右坐标
            int right = position[0] + position[1];
            //边长
            int edge = position[1];
            //当前最高的高度
            int curMaxHigh = query(root, left, right);
            //更新线段树 给所有范围更新最大值为curMaxHigh + edge
            root = update(root, left, right, curMaxHigh + edge);
            //高度比较
            curMax = Math.max(curMax, curMaxHigh + edge);
            res.add(curMax);
        }
        return res;
    }

    /**
     * 做区间更新
     *
     * @param root   根节点
     * @param left   左范围
     * @param right  右范围
     * @param height 高度
     * @return
     */
    private Node update(Node root, int left, int right, int height) {
        if (root == null) {
            return new Node(left, right, height, right);
        }
        if (left <= root.leftX) {
            root.leftChild = update(root.leftChild, left, right, height);
        } else {
            root.rightChild = update(root.rightChild, left, right, height);
        }
        root.maxR = Math.max(right, root.maxR);
        return root;
    }

    /**
     * 查询范围内的最大高度
     *
     * @param root  根节点
     * @param left  左范围
     * @param right 右范围
     * @return
     */
    private int query(Node root, int left, int right) {
        //如果新节点的左边界大于等于当前树的maxR的话,不需要遍历整颗树
        if (root == null || left >= root.maxR) {
            return 0;
        }
        int curHeight = 0;
        //是否有交集
        if (right > root.leftX && left < root.rightX) {
            curHeight = root.maxHeight;
        }
        curHeight = Math.max(curHeight, query(root.leftChild, left, right));
        if (right > root.leftX) {
            curHeight = Math.max(curHeight, query(root.rightChild, left, right));
        }
        return curHeight;
    }


    public static void main(String[] args) {
//        System.out.println(new $699掉落方块().fallingSquares(new int[][]{
//                {6,1}, {9,2}, {2,4}
//        }));
        System.out.println(new $699掉落方块().fallingSquares2(new int[][]{
//                {6,1}, {9,2}, {2,4}
                {2,2}, {3,2}, {6,1}
        }));

    }
}




