import java.util.HashSet;
import java.util.Set;

/**
 * nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
 * 输入：nums = [5,1,5,2,5,3,5,4]
 * 输出：5
 */
public class $961长度2N数组中找出重复N次元素 {

    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new $961长度2N数组中找出重复N次元素().repeatedNTimes(new int[]{2,1,2,5,3,2}));
    }
}
