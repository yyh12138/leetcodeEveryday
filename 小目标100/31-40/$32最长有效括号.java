import java.util.Stack;

import static java.lang.Math.max;

/**
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 */
public class $32最长有效括号 {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isExtracted = new boolean[s.length()];// 默认false
        int ans = 0, left = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 多余的右括号是不需要的，标记
                if(stack.empty()) {
                    isExtracted[i] = true;
                } else {
                    stack.pop();
                }
            }
        }
        while(!stack.empty()) {
            isExtracted[stack.firstElement()] = true;
            stack.pop();
        }
        // 寻找标记与标记之间的最大长度
        for(int i = 0; i < s.length(); i++) {
            if(isExtracted[i]) {
                len = 0;
                continue;
            }
            len++;
            ans = Math.max(ans, len);
        }
        return ans;
    }

    public int longestValidParentheses2(String s) {
        int n = s.length(),cout = 0,max = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)==')'){
                if(cout>0) {
                    dp[i] = dp[i - 1] + 2;
                    dp[i] += i > dp[i] ? dp[i - dp[i]] : 0;
                    cout--;
                }
            }else {
                cout++;
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new $32最长有效括号().longestValidParentheses2("(()()")); // 2
    }
}
