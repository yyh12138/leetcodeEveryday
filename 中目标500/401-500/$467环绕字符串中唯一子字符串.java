import java.util.HashSet;
import java.util.Set;

/**
 * 把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串。
 * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。
 * 输入: p = "a"
 * 输出: 1
 * 解释: 字符串 s 中只有一个"a"子字符。
 * 输入: p = "zab"
 * 输出: 6
 * 解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
 */
public class $467环绕字符串中唯一子字符串 {

    // 唯一的子字符串的数量就等于：分别以a,b,c,d...z结尾的最长子字符串的长度之和
    public int findSubstringInWraproundString(String p) {
        int n = p.length();
        if(n < 1) { return 0; }
        int ret = 0;
        int[] count = new int[26];
        char[] str = p.toCharArray();
        int curMaxLen = 1;
        for(int i = 0; i < n; ++i) {
            if(i > 0 && (str[i]-str[i-1] == 1 || str[i-1]-str[i] == 25)) {
                curMaxLen++;
            } else {
                curMaxLen = 1;
            }
            count[str[i]-'a'] = Math.max(count[str[i]-'a'], curMaxLen);
        }
        for(int temp : count) {
            ret += temp;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new $467环绕字符串中唯一子字符串().findSubstringInWraproundString("zaba"));
    }

}
