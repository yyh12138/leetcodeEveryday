import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请你选择数组的两个不同下标i和j，使(nums[i]-1)*(nums[j]-1)取得最大值。
 * 输入：nums = [3,4,5,2]   输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12
 */
public class $1464数组中两元素的最大乘积 {

    public int maxProduct(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        return (nums[len-1]-1)*(nums[len-2]-1);
    }

    public static void main(String[] args) {
        System.out.println(new $1464数组中两元素的最大乘积().maxProduct(new int[]{3,4,5,2}));
    }
}
