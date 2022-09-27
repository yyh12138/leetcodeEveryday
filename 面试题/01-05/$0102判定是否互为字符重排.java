import java.util.HashMap;
import java.util.Map;

/**
 * 确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 输入: s1 = "abc", s2 = "bca"  输出: true
 */
public class $0102判定是否互为字符重排 {

    public boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            Integer value = map1.getOrDefault(c, 0);
            map1.put(c, ++value);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            Integer value = map2.getOrDefault(c, 0);
            map2.put(c, ++value);
        }
        return map1.equals(map2);
    }

    public static void main(String[] args) {
        System.out.println(new $0102判定是否互为字符重排().CheckPermutation("abcd", "bced"));
    }
}
