/**
 * 给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）
 *
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"   输出：True
 */
public class $0109字符串轮转 {

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length()!=s2.length()) {
            return false;
        }
        String ss = s2+s2;
        return ss.contains(s1);
    }

    public static void main(String[] args) {
        System.out.println(new $0109字符串轮转().isFlipedString("waterbottle", "erbottlewat"));
    }
}
