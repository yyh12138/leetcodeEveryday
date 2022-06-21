/**
 * 用 "[.]" 代替了每个 "."
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 */
public class $1108IP地址无效化 {

    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (c=='.') {
                String s = "[.]";
                res.append(s);
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new $1108IP地址无效化().defangIPaddr("1.1.1.1"));
    }
}
