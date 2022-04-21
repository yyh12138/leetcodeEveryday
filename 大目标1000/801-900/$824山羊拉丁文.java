import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 *
 *     如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 *         例如，单词 "apple" 变为 "applema" 。
 *     如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 *         例如，单词 "goat" 变为 "oatgma" 。
 *     根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 *         例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 *
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 */

public class $824山羊拉丁文 {

    List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    /**
     * 输入：sentence = "The quick brown fox jumped over the lazy dog"
     * 输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
     * @param sentence
     * @return
     */
    public String toGoatLatin(String sentence) {
        String[] ss = sentence.split(" ");
        // 加ma,a
        for (int i = 0; i < ss.length; i++) {
            char[] suffix = new char[i+1];
            Arrays.fill(suffix, 'a');
            if (!vowel.contains(ss[i].charAt(0))) {
                ss[i] = replaceWord(ss[i]);
            }
            ss[i] = ss[i] + "ma" + String.valueOf(suffix);
        }
        // 合并
        String res = "";
        for (int i=0; i<ss.length; i++) {
            if (i==ss.length-1) {
                res = res + ss[i];
            }else {
                res = res + ss[i] + " ";
            }
        }
        return res;
    }
    private String replaceWord(String word) {
        String res = "";
        char first = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            res = res + word.charAt(i);
        }
        res = res + first;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $824山羊拉丁文().toGoatLatin("The quick brown fox jumped over the lazy dog"));

    }
}
