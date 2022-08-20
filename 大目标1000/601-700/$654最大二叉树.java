import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 *     创建一个根节点，其值为 nums 中的最大值。
 *     递归地在最大值 左边 的 子数组前缀上 构建左子树。
 *     递归地在最大值 右边 的 子数组后缀上 构建右子树。
 *
 * 输入：nums = [3,2,1,6,0,5]   输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 *     - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 *         - 空数组，无子节点。
 *         - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 *             - 空数组，无子节点。
 *             - 只有一个元素，所以子节点是一个值为 1 的节点。
 *     - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 *         - 只有一个元素，所以子节点是一个值为 0 的节点。
 *         - 空数组，无子节点。
 */
public class $654最大二叉树 {
    // [3,2,1,6,0,5]
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = construct(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        root.print();
        return root;
    }

    private TreeNode construct(List<Integer> nums) {
        if (nums.size()==0) {
            return null;
        }
        int i = findMax(nums);
        TreeNode root = new TreeNode();
        root.val = nums.get(i);
        root.left = construct(nums.subList(0, i));
        root.right = construct(nums.subList(i+1, nums.size()));
        return root;
    }

    private int findMax(List<Integer> nums) {
        int max = -1, index = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (max < nums.get(i)) {
                max = nums.get(i);
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        new $654最大二叉树().constructMaximumBinaryTree(new int[] {3,2,1,6,0,5});
    }
}
