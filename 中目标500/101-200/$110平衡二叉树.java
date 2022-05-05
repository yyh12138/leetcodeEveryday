/**
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 */
public class $110平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) >= 0;
    }

    private int dfs(TreeNode root) {
        if (root==null) {
            return 0;
        }else {
            int lh = dfs(root.left), rh = dfs(root.right);
            if (lh>=0 && rh>=0 && Math.abs(lh-rh)<=1) {
                return Math.max(lh, rh) + 1;
            }else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9,null,null),
                new TreeNode(20,
                        new TreeNode(15,null,null),
                        new TreeNode(7,null,null)));
        System.out.println(new $110平衡二叉树().isBalanced(root));
    }
}
