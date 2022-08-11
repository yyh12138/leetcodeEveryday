import java.util.ArrayList;
import java.util.List;

/**
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 *
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 */
public class $1417重新格式化字符串 {

    public String reformat(String s) {
        List<Character> cList = new ArrayList<>();
        List<Integer> nList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                nList.add(Integer.parseInt(c+""));
            }else {
                cList.add(c);
            }
        }
        StringBuilder res = new StringBuilder();
        if (cList.size() >= nList.size()) {
            if (cList.size()-nList.size() <= 1) {
                for (int i = 0; i < cList.size(); i++) {
                    res.append(cList.get(i));
                    if (i<nList.size()) {
                        res.append(nList.get(i));
                    }
                }
                return res.toString();
            }
        }else {
            if (nList.size()-cList.size() <= 1) {
                for (int i = 0; i < nList.size(); i++) {
                    res.append(nList.get(i));
                    if (i<cList.size()) {
                        res.append(cList.get(i));
                    }
                }
                return res.toString();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new $1417重新格式化字符串().reformat("leet1234"));
    }
}
