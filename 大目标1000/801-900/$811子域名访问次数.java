import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 计数配对域名 是遵循 "rep d1.d2.d3" 或 "rep d1.d2" 格式的一个域名表示，其中 rep 表示访问域名的次数，d1.d2.d3 为域名本身。
 *     例如，"9001 discuss.leetcode.com" 就是一个 计数配对域名 ，表示 discuss.leetcode.com 被访问了 9001 次。
 * 给你一个 计数配对域名 组成的数组 cpdomains ，解析得到输入中每个子域名对应的 计数配对域名 ，并以数组形式返回。
 *
 * 输入：cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * 输出：["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * 解释：按照前文描述，会访问 "google.mail.com" 900 次，"yahoo.com" 50 次，"intel.mail.com" 1 次，"wiki.org" 5 次。
 * 而对于父域名，会访问 "mail.com" 900 + 1 = 901 次，"com" 900 + 50 + 1 = 951 次，和 "org" 5 次。
 */

public class $811子域名访问次数 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<cpdomains.length; i++){
            String[] s = cpdomains[i].split(" ");
            int a = Integer.parseInt(s[0]);
            inc(map, s[1], a);
            for(int j=0; j<s[1].length(); j++) {
                if(s[1].charAt(j)=='.') {
                    inc(map, s[1].substring(j+1), a);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(String s: map.keySet()) {
            ans.add(map.get(s)+" "+s);
        }
        return ans;
    }
    void inc(Map<String,Integer> map, String s, int a) {
        map.put(s,map.getOrDefault(s,0)+a);
    }

    public static void main(String[] args) {
        System.out.println(new $811子域名访问次数().subdomainVisits(new String[] {
                "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
        }));
    }
}
