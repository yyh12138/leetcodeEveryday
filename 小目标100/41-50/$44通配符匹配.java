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

    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, length = s.length(), len = p.length();
        StringBuilder ss = new StringBuilder(s);
        StringBuilder pattern = new StringBuilder(p);
        while (i<length && j<len) {
            if (pattern.charAt(j)=='?') {

            }else if (pattern.charAt(j)=='*') {
                for (int k = 0; k <= len; k++) {

                }
            }else {
                if (ss.charAt(i)==pattern.charAt(j)) {
                    ss.deleteCharAt(i);
                    pattern.deleteCharAt(i);
                }else {
                    return false;
                }
            }
            i++;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new $44通配符匹配().isMatch("cdcb", "*c?b"));
    }
}
