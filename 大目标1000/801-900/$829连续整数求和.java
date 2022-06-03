/**
 * 输入: n = 5
 * 输出: 2
 * 解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 *
 * 输入: n = 15
 * 输出: 4
 * 解释: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 */
public class $829连续整数求和 {

    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int i = 1; (n -= i) >= 0; ++i) {
            if(n % i == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new $829连续整数求和().consecutiveNumbersSum(15));
    }
}
