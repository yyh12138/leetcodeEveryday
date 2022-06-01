import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 */
public class $473火柴拼正方形 {

    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        return allocate(nums, nums.length - 1, new int[4], sum / 4);
    }

    private boolean allocate(int[] nums, int pos, int[] sides, int side) {
        if (pos == -1) {
            return sides[0] == side && sides[1] == side && sides[2] == side;
        }
        for (int i = 0; i < 4; ++i) {
            if (sides[i] + nums[pos] > side) {
                continue;
            }
            sides[i] += nums[pos];
            if (allocate(nums, pos - 1, sides, side)) {
                return true;
            }
            sides[i] -= nums[pos];
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new $473火柴拼正方形().makesquare(new int[]{1,2,2,3,4,4}));
    }
}
