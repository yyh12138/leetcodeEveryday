import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 */
public class $513找树左下角值 {

    int level = 0;
    TreeNode last;

    public int findBottomLeftValue(TreeNode root) {
        levelOrder(root);
        return last.val;
    }

    private void levelOrder(TreeNode root) {
        if (root==null) {
            return ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (queue.isEmpty()) {
                level++;
                last = tmp;
            }
            if (tmp.right!=null) {
                queue.offer(tmp.right);
            }
            if (tmp.left!=null) {
                queue.offer(tmp.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
                                    new TreeNode(3, new TreeNode(5), new TreeNode(6)));
        System.out.println(new $513找树左下角值().findBottomLeftValue(root));
    }
}
