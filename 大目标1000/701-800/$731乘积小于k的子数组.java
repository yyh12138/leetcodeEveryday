import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 *
 */
public class $731乘积小于k的子数组 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int multiply = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<k) {
                multiply = nums[i];
                res++;
                for (int j = i+1; j < nums.length; j++) {
                    if (multiply*nums[j]<k) {
                        multiply *= nums[j];
                        res++;
                    }else {
                        break;
                    }
                }
            }
        }
        return res;
    }

    // 滑动窗口
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new $731乘积小于k的子数组().numSubarrayProductLessThanK(new int[]{
                10,9,10,4,3,8,3,3,6,2,10,10,9,3
        },19));// 18
    }
}
