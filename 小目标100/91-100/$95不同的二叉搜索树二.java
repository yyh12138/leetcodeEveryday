import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 *
 */
public class $95不同的二叉搜索树二 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) { return new LinkedList<>(); }
        return dfs(1, n);
    }
    // dfs
    private List<TreeNode> dfs(int first, int last) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (first > last) {
            allTrees.add(null);
            return allTrees;
        }
        // 选择所有可能的根节点
        for (int i = first; i <= last; i++) {
            List<TreeNode> leftTrees = dfs(first, i - 1);
            List<TreeNode> rightTrees = dfs(i + 1, last);
            // 现在在这层递归中，有了根节点，有了左子树集合和右子树集合
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    // 装入所有根节点
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        System.out.println(new $95不同的二叉搜索树二().generateTrees(3));
    }
}
