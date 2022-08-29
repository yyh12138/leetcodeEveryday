import java.util.Arrays;

/**
 * 输入：nums = [2,5,1,3,4,7], n = 3   输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 *
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 */
public class $1470重新排列数组 {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int i = 0, j = n;
        for (int k = 0; k < 2*n; k++) {
            if (k%2==0) {
                res[k] = nums[i++];
            }else {
                res[k] = nums[j++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $1470重新排列数组().shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }
}
