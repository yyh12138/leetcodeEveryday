import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 * 将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 */
public class $905奇偶排序数组 {

    public int[] sortArrayByParity(int[] nums) {
        List<Integer> tmp1 = new ArrayList<>();
        List<Integer> tmp2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2==0) {
                tmp2.add(nums[i]);
            }else {
                tmp1.add(nums[i]);
            }
        }
        tmp2.addAll(tmp1);
        return tmp2.stream().mapToInt(Integer::valueOf).toArray();
    }

    // 双指针+一次遍历
    public int[] sortArrayByParity2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[left++] = num;
            } else {
                res[right--] = num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $905奇偶排序数组().sortArrayByParity(new int[]{3,1,2,4})));
    }
}
