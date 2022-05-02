import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 输入: "<DIV>This is the first line <![CDATA[<div>]]></DIV>"
 * 输出: True
 * 解释:
 * 代码被包含在了闭合的标签内： <DIV> 和 </DIV> 。
 * TAG_NAME 是合法的，TAG_CONTENT 包含了一些字符和 cdata 。
 * 即使 CDATA_CONTENT 含有不匹配的起始标签和不合法的 TAG_NAME，它应该被视为普通的文本，而不是标签。
 * 所以 TAG_CONTENT 是合法的，因此代码是合法的。最终返回True。
 *
 * 输入: "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"
 * 输出: True
 * 解释:
 * 我们首先将代码分割为： start_tag|tag_content|end_tag 。
 * start_tag -> "<DIV>"
 * end_tag -> "</DIV>"
 * tag_content 也可被分割为： text1|cdata|text2 。
 * text1 -> ">>  ![cdata[]] "
 * cdata -> "<![CDATA[<div>]>]]>" ，其中 CDATA_CONTENT 为 "<div>]>"
 * text2 -> "]]>>]"
 */
public class $591标签验证器 {

    public boolean isValid(String code) {
        int n = code.length();
        Deque<String> tags = new ArrayDeque<>();

        int i = 0;
        while (i < n) {
            if (code.charAt(i) == '<') {
                if (i == n - 1) {
                    return false;
                }
                if (code.charAt(i + 1) == '/') {
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagname = code.substring(i + 2, j);
                    if (tags.isEmpty() || !tags.peek().equals(tagname)) {
                        return false;
                    }
                    tags.pop();
                    i = j + 1;
                    if (tags.isEmpty() && i != n) {
                        return false;
                    }
                } else if (code.charAt(i + 1) == '!') {
                    if (tags.isEmpty()) {
                        return false;
                    }
                    if (i + 9 > n) {
                        return false;
                    }
                    String cdata = code.substring(i + 2, i + 9);
                    if (!"[CDATA[".equals(cdata)) {
                        return false;
                    }
                    int j = code.indexOf("]]>", i);
                    if (j < 0) {
                        return false;
                    }
                    i = j + 1;
                } else {
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagname = code.substring(i + 1, j);
                    if (tagname.length() < 1 || tagname.length() > 9) {
                        return false;
                    }
                    for (int k = 0; k < tagname.length(); ++k) {
                        if (!Character.isUpperCase(tagname.charAt(k))) {
                            return false;
                        }
                    }
                    tags.push(tagname);
                    i = j + 1;
                }
            } else {
                if (tags.isEmpty()) {
                    return false;
                }
                ++i;
            }
        }

        return tags.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new $591标签验证器().isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
    }
}
