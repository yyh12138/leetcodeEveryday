import java.util.Arrays;

/**
 * 输入: a = "1010", b = "11"
 * 输出: "10101"
 */

public class $67二进制求和 {

    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) {
            return b;
        }
        if(b == null || b.length() == 0) {
            return a;
        }

        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int c = 0;  // 进位
        while(i >= 0 || j >= 0) {
            if(i >= 0) {
                c += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                c += b.charAt(j--) - '0';
            }
            stb.append(c%2);
            c >>= 1;
        }

        String res = stb.reverse().toString();
        return c > 0 ? '1' + res : res;
    }

    public static void main(String[] args) {
        System.out.println(new $67二进制求和().addBinary("1111", "11"));
    }
}
