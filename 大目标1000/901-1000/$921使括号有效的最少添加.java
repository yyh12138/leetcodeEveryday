import java.util.Stack;

/**
 *     它是一个空字符串，或者
 *     它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 *     它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串 s ，移动N次，你就可以在字符串的任何位置插入一个括号。
 *     例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
 * 返回为使结果字符串 s 有效而必须添加的最少括号数。
 *
 * 输入：s = "()(()"   输出：1
 */
public class $921使括号有效的最少添加 {

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='(') {
                stack.push(c);
            }else {
                if (!stack.empty()) {
                    Character peek = stack.peek();
                    if (peek=='(') {
                        stack.pop();
                    }else {
                        stack.push(c);
                    }
                }else {
                    stack.push(c);
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(new $921使括号有效的最少添加().minAddToMakeValid("()))(("));
    }
}
