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

    /**
     * 判断当有i个连续数字时，是否满足条件；当有i+1个数字时，数组中第i+1个数与第一个数的差为i，所以N每执行一次循环都减i。若能整除i，那么这些连续整数的开始的元素就是N/i了
     * @param n
     * @return
     */
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
