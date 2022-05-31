import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class $98验证二叉搜索树 {

    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        for (int i = 0; i < res.size()-1; i++) {
            if (res.get(i+1)<=res.get(i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private void inorder(TreeNode root) {
        if (root==null) {
            return;
        }else {
            if (root.left!=null && root.left.val>=root.val) {
                flag = false;
            }else {
                inorder(root.left);
            }
            if (root.right!=null && root.right.val<=root.val) {
                flag = false;
            }else {
                inorder(root.right);
            }
        }
    }

    private void preOrder(TreeNode node, List<Integer> res) {
        if(node==null) {
            return;
        }else {
            preOrder(node.left, res);
            res.add(node.val);
            preOrder(node.right, res);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1),
                                    new TreeNode(3));
        System.out.println(new $98验证二叉搜索树().isValidBST(root));
    }
}
