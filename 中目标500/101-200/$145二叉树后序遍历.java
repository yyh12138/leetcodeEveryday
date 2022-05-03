import java.util.ArrayList;
import java.util.List;

public class $145二叉树后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(TreeNode node, List<Integer> res) {
        if(node==null) {
            return;
        }else {
            postOrder(node.left, res);
            postOrder(node.right, res);
            res.add(node.val);
        }
    }
}
