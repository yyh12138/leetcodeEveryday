/**
 * 返回 nums 中一个 升序 子数组的最大可能元素和。
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为升序子数组。
 * 大小为 1 的子数组也视作升序子数组。
 *
 * 输入：nums = [10,20,30,5,10,50]    输出：65
 * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 */
public class $1800最大升序子数组和 {

    public int maxAscendingSum(int[] nums) {
        int max = -1, last = -1, now = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (last>=num) {
                max = Math.max(max, now);
                now = num;
            }else {
                now += num;
            }
            last = num;
        }
        return Math.max(max, now);
    }

    public static void main(String[] args) {
        System.out.println(new $1800最大升序子数组和().maxAscendingSum(new int[] {12,17,15,13,10,11,12}));
    }
}
