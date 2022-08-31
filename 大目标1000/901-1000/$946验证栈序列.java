import java.util.Stack;

/**
 * 每个序列中的值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]   输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 */
public class $946验证栈序列 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        stack.push(pushed[i++]);
        while (i<pushed.length && j<popped.length) {
            if (!stack.empty()) {
                if (stack.peek()!=popped[j]) {
                    stack.push(pushed[i]);
                    i++;
                }else {
                    stack.pop();
                    j++;
                }
            }else {
                stack.push(pushed[i++]);
            }
        }
        while (j < popped.length) {
            if (popped[j]==stack.peek()) {
                stack.pop();
            }else {
                return false;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new $946验证栈序列().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{2,1,5,3,4}));
    }
}
