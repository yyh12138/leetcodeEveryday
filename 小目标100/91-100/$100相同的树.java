import java.util.ArrayList;
import java.util.List;

/**
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}


public class $100相同的树 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean[] flag = new boolean[1];
        flag[0] = true;
        isSameNode(p, q, flag);
        return flag[0];
    }

    private void isSameNode(TreeNode p, TreeNode q, boolean[] flag) {
        if ((p!=null&&q==null) || (p==null&&q!=null)) {
            flag[0] = false;
            return;
        }
        if (p==null&&q==null) {
            return;
        }
        isSameNode(p.left, q.left, flag);
        if (p.val!=q.val) {
            flag[0] = false;
        }
        isSameNode(p.right, q.right, flag);
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
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(4));
        TreeNode q = new TreeNode(1, null, new TreeNode(4));
        System.out.println(new $100相同的树().isSameTree(p, q));
    }
}
