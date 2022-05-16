import java.util.ArrayList;
import java.util.List;

/**
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 * 输出: 2
 */
public class $0406后继者 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        }else {
            TreeNode node = inorderSuccessor(root.left, p);
            return node == null ? root : node;
        }
    }

    private void inOrder(TreeNode node, List<Integer> res) {
        if(node==null) {
            return;
        }else {
            inOrder(node.left, res);
            res.add(node.val);
            inOrder(node.right, res);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,null,new TreeNode(3));
        System.out.println(new $0406后继者().inorderSuccessor(root, new TreeNode(2)).val);
    }
}
