/**
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 */

public class $953验证外星语词典 {


    int[] alphabet = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        // 重写字母表
        for (int i = 0; i < 26; i++) {
            alphabet[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length-1; i++) {
            if (compare(words[i], words[i+1])>0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String w1, String w2) {
        int l1 = w1.length();
        int l2 = w2.length();
        int min = Math.min(l1, l2);
        for (int i = 0; i < min; i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);
            if (c1!=c2) {
                return alphabet[c1-'a'] - alphabet[c2-'a'];
            }
        }
        return l1-l2;
    }

    public static void main(String[] args) {
        System.out.println(new $953验证外星语词典().isAlienSorted(new String[]{"word","world","row"},"worldabcefghijkmnpqstuvxyz"));
    }
}
