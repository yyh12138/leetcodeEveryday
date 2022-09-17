/**
 * 返回两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回-1 。
 * 输入：s = "cabbac"    输出：4
 * 解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
 */
public class $1624两字符之间的最长子字符串 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-1; j >= i+max+1 ; j--) {
                if (s.charAt(i)==s.charAt(j)) {
                    max = Math.max(max, j-i-1);
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new $1624两字符之间的最长子字符串().maxLengthBetweenEqualCharacters("cabbceay"));
    }
}
