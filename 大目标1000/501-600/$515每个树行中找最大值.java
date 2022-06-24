import java.util.*;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class $515每个树行中找最大值 {

    List<Integer> res = new ArrayList<>();
    List<Integer> levellist = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> tmp_queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            levellist.add(temp.val);
            if (temp.left != null) {
                tmp_queue.offer(temp.left);
            }
            if (temp.right != null) {
                tmp_queue.offer(temp.right);
            }
            if (queue.isEmpty()) {
                Integer max = Collections.max(levellist);
                res.add(max);
                levellist.clear();
                queue.addAll(tmp_queue);
                tmp_queue.clear();
            }
        }
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root, int curHeight) {
        if (curHeight == res.size()) {
            res.add(root.val);
        } else {
            res.set(curHeight, Math.max(res.get(curHeight), root.val));
        }
        if (root.left != null) {
            dfs(res, root.left, curHeight + 1);
        }
        if (root.right != null) {
            dfs(res, root.right, curHeight + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3,new TreeNode(5),new TreeNode(3)),
                                new TreeNode(2,null,new TreeNode(9)));
        System.out.println(new $515每个树行中找最大值().largestValues(root));
    }
}
