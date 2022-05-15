import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 */
public class $41缺失的第一个正数 {
    // 排序
    public int firstMissingPositive2(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted().distinct().collect(Collectors.toList());
        int min = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)>0) {
                if (list.get(i)>min) {
                    return min;
                }else {
                    min++;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new $41缺失的第一个正数().firstMissingPositive(new int[]{1,1,2,0,-3}));
    }
    // 时间O(n) 空间O(1) 原地Hash -> 将i映射到i-1的位置上
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // 满足在指定范围内、并且没有放在正确的位置上，才交换
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // 最终结果为[1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
