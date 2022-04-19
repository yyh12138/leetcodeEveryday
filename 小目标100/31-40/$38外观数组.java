import java.util.ArrayList;
import java.util.List;

/**
 * 输入：n = 4
 * 输出："1211"
 * 解释：
 * countAndSay(1) = "1"
 * countAndSay(2) = 读 "1" = 一 个 1 = "11"
 * countAndSay(3) = 读 "11" = 二 个 1 = "21"
 * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
 */

public class $38外观数组 {

    public String countAndSay(int n) {
        String res = dfs(1, "1", n);
        return res;
    }

    private String dfs(int index, String str, int level) {
        if (index==level) {
            return str;
        }else {
            String temp = "";
            char t_word = str.charAt(0);
            for (int i = 0; i < str.length(); i++) {
                char num = str.charAt(i);
                if (i>0 && t_word==num) {
                    continue;
                }
                if (i>0 && t_word!=num) {
                    t_word = num;
                }
                int amount = 0;
                for (int am = i; am < str.length(); am++) {
                    if (str.charAt(am)==num) {
                        amount++;
                    }else {
                        break;
                    }
                }
                temp = temp + amount+""+num;
            }
            str = temp;
            return dfs(index+1, str, level);
        }
    }

    public static void main(String[] args) {
        System.out.println(new $38外观数组().countAndSay(6));
    }
}
