/**
 *
 */
public class $104二叉树最大深度 {

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int height) {
        if (root==null) {
            return height;
        }else {
            int leftDeep = dfs(root.left, height);
            int rightDeep = dfs(root.right, height);
            return Math.max(leftDeep, rightDeep)+1;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9),
                new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(new $104二叉树最大深度().maxDepth(root));
    }
}
