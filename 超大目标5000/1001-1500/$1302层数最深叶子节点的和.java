import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 */
public class $1302层数最深叶子节点的和 {

    int deep = 0, sum = 0, res = 0;
    Queue<TreeNode> nodes = new LinkedList<>();
    List<TreeNode> subList = new ArrayList<>();
    public int deepestLeavesSum(TreeNode root) {
        if (root.left==null && root.right==null) {
            return root.val;
        }
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node.left!=null) {
                subList.add(node.left);
                sum += node.left.val;
            }
            if (node.right!=null) {
                subList.add(node.right);
                sum += node.right.val;
            }
            if (nodes.isEmpty()) {
                deep++;
                nodes.addAll(subList);
                if (sum!=0) {
                    res = sum;
                    sum = 0;
                }
                subList.clear();
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, new TreeNode(2,new TreeNode(4,new TreeNode(7),null),new TreeNode(5)),
//                new TreeNode(3,null,new TreeNode(6,null,new TreeNode(8))));
        TreeNode root = new TreeNode(2);
        System.out.println(new $1302层数最深叶子节点的和().deepestLeavesSum(root));
    }
}
