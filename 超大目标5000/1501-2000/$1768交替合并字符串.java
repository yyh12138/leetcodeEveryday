/**
 * 从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回合并后的字符串 。
 *
 * 输入：word1 = "ab", word2 = "pqrs"    输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 */
public class $1768交替合并字符串 {

    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder str = new StringBuilder();
        while (i<word1.length() && j<word2.length()) {
            str.append(word1.charAt(i++));
            str.append(word2.charAt(j++));
        }
        if (i<word1.length()) {
            str.append(word1.substring(i));
        }
        if (j<word2.length()) {
            str.append(word2.substring(j));
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new $1768交替合并字符串().mergeAlternately("abcd", "pq"));
    }
}
