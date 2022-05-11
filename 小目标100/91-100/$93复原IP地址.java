import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你不能重新排序或删除 s 中的任何数字。你可以按任何顺序返回答案。
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 */
public class $93复原IP地址 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length()>=4&&s.length()<=12) {
            dfs(res, s, "", 0, 1);
        }
        return res;
    }

    private void dfs(List<String> res, String s, String ss, int index, int now) {
        if (now==4 && index<s.length()) {
            String last = s.substring(index);
            if (Integer.parseInt(last)<=255&&Integer.parseInt(last)>=0) {
                if (last.charAt(0)=='0') {
                    if (Integer.parseInt(last)==0 && last.length()==1) {
                        res.add(ss+last);
                    }
                }else {
                    res.add(ss+last);
                }
            }
        }else {
            for (int i = 1; i < 4; i++) {
                if (i+index<=s.length()) {
                    String sub = s.substring(index, i + index);
                    if (Integer.parseInt(sub)<=255 && Integer.parseInt(sub)>=0) {
                        if (sub.charAt(0)!='0' || (sub.charAt(0)=='0'&&Integer.parseInt(sub)==0&&sub.length()==1)) {
                            now++;
                            dfs(res, s, ss + sub + ".", i+index, now);
                            now--;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new $93复原IP地址().restoreIpAddresses("100023"));
    }
}
