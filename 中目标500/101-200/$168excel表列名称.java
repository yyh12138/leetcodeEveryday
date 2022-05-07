/**
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 *
 * 输入：columnNumber = 1
 * 输出："A"
 */

public class $168excel表列名称 {

    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new $168excel表列名称().convertToTitle(702));
    }
}
