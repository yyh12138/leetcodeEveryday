/**
 * 输入：sentence = "i love eating burger", searchWord = "burg"  输出：4
 * 解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
 *
 * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）
 * 如果 searchWord 不是任何单词的前缀，则返回 -1
 */
public class $1455检查单词是否为句中其他单词前缀 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (isPrefix(words[i], searchWord)) {
                return i+1;
            }
        }
        return -1;
    }

    private boolean isPrefix(String word, String s) {
        if (word.length()<s.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new $1455检查单词是否为句中其他单词前缀().isPrefixOfWord("this dream", "d"));
    }
}
