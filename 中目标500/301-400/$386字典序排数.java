import java.util.ArrayList;
import java.util.List;

/**
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 */

public class $386字典序排数 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int cur = 1;
        for(int i = 0; i < n; i++) {
            ans.add(cur);
            if(cur * 10 <= n) {
                cur *= 10;
            } else {
                // 枚举到当前前缀的最深处了，需要回到上一层并到下一个同层节点
                while(cur % 10 == 9 || cur >= n) {
                    cur /= 10;
                }
                cur++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new $386字典序排数().lexicalOrder(200));
    }
}
