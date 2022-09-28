import java.util.ArrayList;
import java.util.List;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * 输入: k = 5   输出: 9
 */
public class $1709第k个数 {
    // 1，3，5，7，9，15，21. 25, 27,
    // 某个满足的数，一定是之前resultA*3或者是resultB*5或者是resultC*7 的结果，并且结果一定是这三个乘积的最小值
    // 因此，只要能够记录resultA、resultB、resultC，再相互与3、5、7相乘，取其中的最小值，就是当前的目标值
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;// 第一个数是1
        int p3 = 0,p5 = 0,p7 = 0;// 指向等待乘以3/5/7的dp下标
        for(int i=1; i<k; i++){
            dp[i] = Math.min(3*dp[p3], Math.min(5*dp[p5],7*dp[p7]));// 归并，选择最小的加入
            if(dp[i] == 3*dp[p3]) { p3++; }
            if(dp[i] == 5*dp[p5]) { p5++; }
            if(dp[i] == 7*dp[p7]) { p7++; }
        }
        return dp[k-1];
    }

    public static void main(String[] args) {
        System.out.println(new $1709第k个数().getKthMagicNumber(10));
    }
}
