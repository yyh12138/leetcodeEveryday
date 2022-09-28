import java.util.ArrayList;
import java.util.List;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * 输入: k = 5   输出: 9
 */
public class $1709第k个数 {
    // 1，3，5，7，9，15，21. 25, 27,
    public int getKthMagicNumber(int k) {
        int [] result = new int[k];
        result[0] = 1;
        // 某一个满足结果的数，一定是之前的某个 resultA*3 或者是 resultB*5 或者是 resultC*7 的结果
        // 并且结果一定是这三个乘积的最小值，因此，只要能够记录resultA、resultB、resultC，再相互与 3、5、7 相乘，取其中的最小值，就是当前的目标值
        int point3 = 0;
        int point5 = 0;
        int point7 = 0;
        for (int i = 1; i < k; i++) {
            int resultN = Math.min(Math.min(result[point3] * 3, result[point5] * 5), result[point7] * 7);
            if (resultN % 3 == 0) {
                point3++;
            }
            if (resultN % 5 == 0) {
                point5++;
            }
            if (resultN % 7 == 0) {
                point7++;
            }
            result[i] = resultN;
        }
        return result[k - 1];
    }

    public static void main(String[] args) {
        System.out.println(new $1709第k个数().getKthMagicNumber(10));
    }
}
