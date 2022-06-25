import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 *
 * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 *      最少花费: 2 + 5 + 3 = 10。
 */
public class $256粉刷房子 {

    /**
     * 当i>0时：
     * dp[i][0]=min(dp[i−1][1],dp[i−1][2])+costs[i][0]
     * dp[i][1]=min(dp[i−1][0],dp[i−1][2])+costs[i][1]
     * dp[i][2]=min(dp[i−1][0],dp[i−1][1])+costs[i][2]
     *
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        //刷第一个颜色
        dp[0][0] = costs[0][0];
        //刷第二个颜色
        dp[0][1] = costs[0][1];
        //刷第三个颜色
        dp[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            //第i个房子刷第一个颜色
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            //第i个房子刷第二个颜色
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            //第i个房子刷第三个颜色
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

    public static void main(String[] args) {
        System.out.println(new $256粉刷房子().minCost(new int[][]{
                {17,2,17}, {16,16,5}, {14,3,19}
        }));
    }

}
