import java.util.ArrayList;
import java.util.List;

/**
 * 输入：text = "  this   is  a sentence "
 * 输出："this   is   a   sentence"
 * 解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
 *
 * 使每对相邻单词之间的空格数目都相等,并最大化该数目.如果不能平均分配空格,将多余的空格放置在字符串末尾,这也意味着返回的字符串与原字符串长度相等
 */
public class $1592重新排列单词间空格 {

    public String reorderSpaces(String text) {
        int spaces = -1;
        text += ' ';
        boolean wFlag = false;
        String res = "";
        StringBuilder word = new StringBuilder();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c==' ') {
                spaces++;
                wFlag = false;
                if (word.length()!=0) {
                    words.add(word.toString());
                }
                word = new StringBuilder();
            }else {
                word.append(c);
                if (!wFlag) {
                    wFlag = true;
                }
            }
        }
        String blank = " ";
        if (words.size()==1) {
            res = words.get(0) + blank.repeat(spaces);
            return res;
        }
        int ave = spaces/(words.size()-1), i = 0;
        for (; i < words.size() - 1; i++) {
            res += words.get(i) + blank.repeat(ave);
        }
        res += words.get(i);
        if (spaces%(words.size()-1)!=0) {
            // 多余的空格放末尾
            res += blank.repeat(spaces%(words.size()-1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $1592重新排列单词间空格().reorderSpaces("a"));
    }
}
