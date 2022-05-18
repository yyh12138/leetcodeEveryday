import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 *
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 */
public class $668乘法表中第K小的数 {

    // 第k小、第k大的数，简单中等题就是优先队列，难题就是二分
    public int findKthNumber(int m, int n, int k) {
        int i = 1, j = m*n+1;
        while (i<j) {
            int mid = (i+j)/2;
            int cnt = findNums(mid, m, n);
            if (cnt>=k) {
                j = mid;
            }else {
                i = mid+1;
            }
        }

        return i;
    }
    // 在m*n的表中得到不大于num的个数
    private int findNums(int num, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(num/i, n);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new $668乘法表中第K小的数().findKthNumber(9895,
                28405,
                100787757));
    }
}
