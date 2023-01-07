import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * 如果可以将x恰好 减到0 ，返回最小操作数；否则，返回-1。
 *
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 */
public class $1658将x减到0的最小操作数 {
    public static void main(String[] args) {
        System.out.println(new $1658将x减到0的最小操作数().minOperations(new int[]{ 1,1,4,2,3 }, 5));
    }
    // 滑动窗口   找中间最长的片段使得 sum(片段) = sum(nums)-x
    public int minOperations(int[] nums, int x) {
        int maxPart = -1;
        int sum = Arrays.stream(nums).sum();
        int currentSum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            currentSum += nums[right++];
            while (currentSum > sum - x && left < nums.length) {
                currentSum -= nums[left++];
            }
            if (currentSum == sum - x) {
                maxPart = Math.max(maxPart, right - left);
            }
        }
        return maxPart == -1 ? -1 : nums.length - maxPart;
    }
}
