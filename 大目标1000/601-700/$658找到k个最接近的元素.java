import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 *     |a - x| < |b - x| 或者
 *     |a - x| == |b - x| 且 a < b
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 */
public class $658找到k个最接近的元素 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int left = Arrays.binarySearch(arr, x);
        if (left<0) {
            left = -(left+1)-1;
        }
        int right = left + 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            }else if (right>=arr.length) {
                left--;
            }else if (x-arr[left] <= arr[right]-x) {
                left--;
            }else {
                right++;
            }
        }
        for (int i = left+1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $658找到k个最接近的元素().findClosestElements(new int[]{1,3,4,5,18},3,5));
    }
}
