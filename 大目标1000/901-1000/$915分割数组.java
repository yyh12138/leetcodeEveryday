/**
 * 数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 *     left 中的每个元素都小于或等于 right 中的每个元素。
 *     left 和 right 都是非空的。
 *     left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 *
 * 输入：nums = [5,0,3,8,6]    输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 */
public class $915分割数组 {
    // 维护两个变量 当前最大值和左数组最大值
    public int partitionDisjoint(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int leftMax = nums[0], max = nums[0], index = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i]<leftMax) {
                leftMax = max;
                index = i;
            }
        }
        return index+1;
    }

    public static void main(String[] args) {
        System.out.println(new $915分割数组().partitionDisjoint(new int[] {5,0,3,8,6}));
    }
}
