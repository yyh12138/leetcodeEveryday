import java.util.Arrays;

/**
 * 输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]    输出：2.00000
 * 解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2 。
 *
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 */
public class $1619删除元素后的数组均值 {

    public double trimMean(int[] arr) {
        int res = 0;
        int numOfRemove = (int) (arr.length * 0.05);
        Arrays.sort(arr);
        for (int i = 0; i < numOfRemove; i++) {
            arr[i] = 0;
            arr[arr.length-1-i] = 0;
        }
        for (int num : arr) {
            res += num;
        }
        return (double)res/(arr.length-2*numOfRemove);
    }

    public static void main(String[] args) {
        System.out.println(new $1619删除元素后的数组均值().trimMean(new int[] {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3}));
    }
}
