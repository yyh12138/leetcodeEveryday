import java.util.ArrayList;
import java.util.List;

public class $144二叉树前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode node, List<Integer> res) {
        if(node==null) {
            return;
        }else {
            res.add(node.val);
            preOrder(node.left, res);
            preOrder(node.right, res);
        }
    }
}
