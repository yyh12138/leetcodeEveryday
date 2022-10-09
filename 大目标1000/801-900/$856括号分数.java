import java.util.Stack;

/**
 * 按下述规则计算该字符串的分数：
 *     () 得 1 分。
 *     AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 *     (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 * 输入： "(()(()))"    输出： 6
 */
public class $856括号分数 {

    int scoreOfParentheses(String S) {
        int deep=0,ans=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == '(') {
                deep++;
            } else {
                deep--;
            }
            if(S.charAt(i)==')' && S.charAt(i-1)=='(') {
                ans += 1 << deep;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new $856括号分数().scoreOfParentheses("(()(()))"));
    }
}
