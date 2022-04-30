import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：nums = [1,3,6], k = 3
 * 输出：0
 * 解释：将 nums 改为 [4,4,4]。分数是 max(nums) - min(nums) = 4 - 4 = 0。
 */

public class $908最小差值一 {

    public int smallestRangeI(int[] nums, int k) {
        List<Integer> collect = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        int min = collect.get(0);
        int max = collect.get(collect.size()-1);
        if (max-min<2*k) {
            return 0;
        }else {
            return max-min-2*k;
        }
    }

    public static void main(String[] args) {
        System.out.println(new $908最小差值一().smallestRangeI(new int[]{1,3,6,10}, 3));
    }
}
