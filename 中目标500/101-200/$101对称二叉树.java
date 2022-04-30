import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 */
public class $101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return cmp(root.left, root.right);
    }

    private boolean cmp(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return cmp(node1.left, node2.right) && cmp(node1.right, node2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3,null,null), new TreeNode(4,null,null)), new TreeNode(2, new TreeNode(4,null,null), new TreeNode(3,null,null)));
        System.out.println(new $101对称二叉树().isSymmetric(root));
    }

}
