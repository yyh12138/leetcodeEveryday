import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入：root = [1,3,2,5,null,null,9,6,null,7]  输出：7
 * 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
 *
 * 一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
 */
public class $662二叉树最大宽度 {
    int height = 0;
    private int maxW = 0;

    public int widthOfBinaryTree(TreeNode root) {
        /**
         假设满二叉树表示成数组序列, 根节点所在的位置为1, 则任意位于i节点的左右子节点的index为2*i, 2*i+1
         用一个List保存每层的左端点, 易知二叉树有多少层List的元素就有多少个. 那么可以在dfs的过程中记录每个
         节点的index及其所在的层level, 如果level > List.size()说明当前节点就是新的一层的最左节点, 将其
         加入List中, 否则判断当前节点的index减去List中对应层的最左节点的index的宽度是否大于最大宽度并更新
         */
        dfs(root, 1, 1, new ArrayList<>());
        return maxW;
    }

    private void dfs(TreeNode r, int level, int index, List<Integer> left) {
        if(r == null) {
            return;
        }
        if(level > left.size()) {
            left.add(index);
        }
        maxW = Math.max(maxW, index - left.get(level-1) + 1);
        dfs(r.left, level+1, index*2, left);
        dfs(r.right, level+1, index*2+1, left);
    }

    private int getLeftBound(TreeNode root) {
        int left = 0;
        for (int i = 1; i <= height; i++) {
            if (root.left!=null) {
                root = root.left;
            }else {
                if (root.right!=null) {
                    left += Math.pow(2, height-i-1);
                    root = root.right;
                }else {
                    // 叶子结点
                }
            }
        }
        return left;
    }

    public int getBinaryTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getBinaryTreeHeight(root.left), getBinaryTreeHeight(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3,new TreeNode(5,new TreeNode(6),null),null),
                                            new TreeNode(2,null,new TreeNode(9,new TreeNode(7),null)));
        System.out.println(new $662二叉树最大宽度().widthOfBinaryTree(root));
    }
}
