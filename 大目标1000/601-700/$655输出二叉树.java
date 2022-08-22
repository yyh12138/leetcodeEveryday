import java.util.*;

/**
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 *     树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 *     矩阵的列数 n 应该等于 2height+1 - 1 。
 *     根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 *     对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 *     继续这一过程，直到树中的所有节点都妥善放置。
 *     任意空单元格都应该包含空字符串 "" 。
 *
 * 输入：root = [1,2,3,null,4]输出：
 * [
 *  ["","","","1","","",""],
 *  ["","2","","","","3",""],
 *  ["","","4","","","",""]
 * ]
 */
public class $655输出二叉树 {

    public List<List<String>> printTree(TreeNode root) {
        int height = getDepth(root);
        int n = (int)Math.pow(2, height) - 1, m = height + 1;
        String[][] table = new String[m][n];
        int r = 0, c = (n-1)/2;
        table[r][c] = root.val+"";
        r++;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        List<TreeNode> level = new ArrayList<>();
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node.left!=null) {
                level.add(node.left);
                table[r][c-(int)Math.pow(2, height-r-1)] = node.left.val+"";
            }
            if (node.right!=null) {
                level.add(node.right);
                table[r][c+(int)Math.pow(2, height-r-1)] = node.right.val+"";
            }
            if (nodes.isEmpty()) {
                nodes.addAll(level);
                level.clear();
                r++;
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            res.add(Arrays.asList(table[i]));
        }
        return res;
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2,null,new TreeNode(4)), new TreeNode(3));
        System.out.println(new $655输出二叉树().printTree(root));
    }
}
