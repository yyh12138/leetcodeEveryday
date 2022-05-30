import java.util.ArrayList;
import java.util.List;

/**
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 */
public class $1022从根到叶的二进制数和 {

    public int sumRootToLeaf(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        inorder(root, res, "");
        int num = 0;
        for (String r : res) {
            int i = Integer.parseInt(r, 2);
            num += i;
        }
        return num;
    }

    private void inorder(TreeNode root, List<String> res, String s) {
        if (root==null) {
            return;
        }
        if (root.left==null && root.right==null) {
            res.add(s+root.val);
            return;
        }else {
            s += root.val;
            inorder(root.left, res, s);
            inorder(root.right, res, s);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(0,new TreeNode(0),new TreeNode(1)),
                                    new TreeNode(1,new TreeNode(0),new TreeNode(1)));
        System.out.println(new $1022从根到叶的二进制数和().sumRootToLeaf(root));
    }
}
