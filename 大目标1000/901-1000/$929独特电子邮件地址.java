import java.util.HashSet;
import java.util.Set;

/**
 * 输入：emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 *
 *
 */

public class $929独特电子邮件地址 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email: emails) {
            String local = email.split("@")[0].split("\\+")[0];
            String host = email.split("@")[1];
            StringBuilder l = new StringBuilder();
            for (int i = 0; i < local.length(); i++) {
                char c = local.charAt(i);
                if (c!='.') {
                    l.append(c);
                }
            }
            set.add(l.toString()+'@'+host);
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new $929独特电子邮件地址().numUniqueEmails(new String[] {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        }));
    }
}
