import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 *
 */
public class $532数组中的kdiff数对 {

    public int findPairs(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);
        int now = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (now==nums[i]) {
                continue;
            }else {
                now = nums[i];
            }
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]-nums[i]==k) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $532数组中的kdiff数对().findPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 3));
    }
}
