import java.util.Arrays;

/**
 * 输入：nums = [0,4,3,0,4]
 * 输出：3
 * 解释：有 3 个元素大于或等于 3 。
 *
 * 非负整数数组nums,存在一个数x，使得nums中恰好有x个元素大于或者等于x，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 * x不必是nums的中的元素。
 * 如果数组 nums 是一个特殊数组 ，返回它的特征值x。否则返回-1。可以证明的是，如果nums是特殊数组，那么其特征值x是唯一的。
 */
public class $1608特殊数组的特征值 {

    public int specialArray(int[] nums) {
        int i = 1;
        for (; i <= nums.length; i++) {
            if (biggerThanX(nums, i)==i) {
                return i;
            }
        }
        return -1;
    }

    private int biggerThanX(int[] nums, int x) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=x) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $1608特殊数组的特征值().specialArray(new int[] {0,4,3,0,4}));
    }
}
