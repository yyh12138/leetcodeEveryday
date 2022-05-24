/**
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 */
public class $965单值二叉树 {

    boolean flag = true;
    public boolean isUnivalTree(TreeNode root) {
        inorder(root, root.val);
        return flag;
    }

    private void inorder(TreeNode root, int val) {
        if (root==null) {
            return;
        }else {
            inorder(root.left, val);
            if (root.val!=val) {
                flag = false;
            }
            inorder(root.right, val);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(1, new TreeNode(2), new TreeNode(1)),
                new TreeNode(1, null, new TreeNode(1)));
        System.out.println(new $965单值二叉树().isUnivalTree(root));
    }
}
