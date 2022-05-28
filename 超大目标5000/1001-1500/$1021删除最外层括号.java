import java.util.ArrayList;
import java.util.List;

/**
 * 输入：s = "(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 *
 */
public class $1021删除最外层括号 {

    public String removeOuterParentheses(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)=='(') {
                dp[i] = dp[i-1] + 1;
            }else {
                dp[i] = dp[i-1] - 1;
            }
        }
        boolean isFirst1 = true;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < dp.length; i++) {
            if (isFirst1 && dp[i]==1){
                isFirst1 = false;
            } else if (dp[i]==0) {
                isFirst1 = true;
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }



    public static void main(String[] args) {
        System.out.println(new $1021删除最外层括号().removeOuterParentheses("(()())(())"));
    }
}
