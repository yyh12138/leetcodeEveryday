/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 输入: s = "acdcb"  p = "a*c?b"
 * 输出: false
 */

public class $44通配符匹配 {

    /**
     * pj与si对应
     *              si==pj && dp[i-1][j-1]    pj=[a-z]
     * dp[i][j]  =  dp[i-1][j-1]              pj=?
     *              dp[i][j-1] || dp[i-1][j]  pj=*
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        // 初始化dp
        initDP(s, p, dp);
        for (int i = 1; i <= s.length(); i++) {
            char si = s.charAt(i-1);
            for (int j = 1; j <= p.length(); j++) {
                char pj = p.charAt(j-1);
                if (pj=='*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else if(pj=='?') {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = (si == pj && dp[i - 1][j - 1]);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private void initDP(String s, String pattern, boolean[][] dp) {
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }
        for (int j = 0; j < pattern.length(); j++) {
            char c = pattern.charAt(j);
            if (c=='*') {
                dp[0][j+1] = true;
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new $44通配符匹配().isMatch("aab", "c*a*b"));
    }
}
