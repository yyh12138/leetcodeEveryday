import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 */

public class $1035两棵二叉搜索树中所有元素 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        inorder(root1, res1);
        inorder(root2, res2);
        res1.addAll(res2);
        return res1.stream().sorted().collect(Collectors.toList());
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, null, new TreeNode(8,null,null));
        TreeNode root2 = new TreeNode(8, new TreeNode(1,null,null), null);
        System.out.println(new $1035两棵二叉搜索树中所有元素().getAllElements(root1, root2));
    }
}
