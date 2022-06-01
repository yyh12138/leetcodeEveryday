import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class $98验证二叉搜索树 {

    boolean flag = true;

    public boolean isValidBST2(TreeNode root) {
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
    private void preOrder(TreeNode node, List<Integer> res) {
        if(node==null) {
            return;
        }else {
            preOrder(node.left, res);
            res.add(node.val);
            preOrder(node.right, res);
        }
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return  validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(2),
                                    new TreeNode(2));
        System.out.println(new $98验证二叉搜索树().isValidBST(root));
    }
}
