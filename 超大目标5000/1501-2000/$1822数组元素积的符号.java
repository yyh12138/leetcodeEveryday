/**
 * 函数 signFunc(x) 将会根据 x 的正负返回特定值：
 *     如果 x 是正数，返回 1 。
 *     如果 x 是负数，返回 -1 。
 *     如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * 返回 signFunc(product) 。
 *
 * 输入：nums = [-1,-2,-3,-4,3,2,1]    输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 */
public class $1822数组元素积的符号 {

    public int arraySign(int[] nums) {
        int plus = 0, minus = 0;
        for (int num : nums) {
            if (num>0) {
                plus++;
            }else if (num<0) {
                minus++;
            }else {
                return 0;
            }
        }
        if (minus%2==0) {
            return 1;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new $1822数组元素积的符号().arraySign(new int[] {41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41}));
    }
}
