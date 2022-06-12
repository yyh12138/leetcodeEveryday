import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 *
 */
public class $890查找和替换模式 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int[] p = new int[27];
            int[] p2 = new int[27];
            boolean match = true;
            for (int i=0;i<pattern.length();i++){
                int index = word.charAt(i) - 'a' + 1;
                int value = pattern.charAt(i) - 'a' + 1;
                if ((p[index] != 0 && p[index] != value)||(p2[value] != 0 && p2[value] != index)){
                    match = false;
                    break;
                }
                p[index] = value;
                p2[value] = index;
            }
            if (match) {
                res.add(word);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $890查找和替换模式().findAndReplacePattern(new String[]{
                "abc","deq","mee","aqq","dkd","ccc"
        }, "abb"));
    }
}
