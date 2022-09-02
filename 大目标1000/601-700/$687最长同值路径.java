/**
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 * 两个节点之间的路径长度 由它们之间的边数表示。
 *
 * 输入：root = [5,4,5,1,1,5]    输出：2
 */
public class $687最长同值路径 {

    private int maxL = 0;

    public int longestUnivaluePath(TreeNode root) {
        if(root == null) {
            return 0;
        }
        getMaxL(root, root.val);
        return maxL;
    }

    private int getMaxL(TreeNode r, int val) {
        if(r == null) return 0;
        int left = getMaxL(r.left, r.val);
        int right = getMaxL(r.right, r.val);
        maxL = Math.max(maxL, left+right); // 路径长度为节点数减1所以此处不加1
        if(r.val == val) {// 和父节点值相同才返回以当前节点所能构成的最长通知路径长度, 否则返回0
            return Math.max(left, right) + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(4,new TreeNode(4),new TreeNode(4)),
                                            new TreeNode(5,null,new TreeNode(5)));
        System.out.println(new $687最长同值路径().longestUnivaluePath(root));
    }
}
