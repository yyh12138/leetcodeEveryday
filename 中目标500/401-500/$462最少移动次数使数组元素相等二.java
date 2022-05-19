import java.util.Arrays;
import java.util.Collections;

/**
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 *
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class $462最少移动次数使数组元素相等二 {

    // 中位数是最优解
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0,j = nums.length - 1, res = 0;
        while (i < j) {
            res += nums[j--] - nums[i++];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $462最少移动次数使数组元素相等二().minMoves2(new int[]{1,10,2,9}));
    }
}
