import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 必须原地修改，只允许使用额外常数空间。
 */

public class $31下一排列 {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        new $31下一排列().nextPermutation(new int[]{4,2,0,2,3,2,0}); // [4,2,0,3,0,2,2]
    }
}
