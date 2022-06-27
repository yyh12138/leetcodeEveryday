public class $521最长特殊序列一 {

    public int findLUSlength(String a, String b) {
        return !a.equals(b) ? Math.max(a.length(), b.length()) : -1;
    }

    public static void main(String[] args) {
        System.out.println(new $521最长特殊序列一().findLUSlength("ab", "abc"));
    }
}
