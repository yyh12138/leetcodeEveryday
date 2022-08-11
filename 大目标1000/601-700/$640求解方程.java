import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 *
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 */
public class $640求解方程 {

    List<String> list = new ArrayList<>();

    public String solveEquation(String equation) {
        String output = "";
        int result, numOfX = 0;
        list = normalize(equation);
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);

        }


        return output;
    }

    private List<String> normalize(String equation) {
        List<String> res = new ArrayList<>();
        List<String> res2 = new ArrayList<>();
        // [2x, +5, -3, +x, -6, -x, +2]
        String[] split = equation.split("=");
        String str1 = split[0], str2 = split[1];
        String tmp = "";
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (!Character.isLetterOrDigit(c)) { // 判断c为符号
                if (res.size()==0 && Character.isLetterOrDigit(tmp.charAt(0))) {
                    tmp = "+" + tmp;
                }
                res.add(tmp);
                tmp = c+"";
            }else {
                tmp += c;
            }
        }
        res.add(tmp);
        tmp = "";
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if (!Character.isLetterOrDigit(c)) { // 判断c为符号
                if (i==0) {
                    tmp += '+';
                    continue;
                }
                if (res2.size()==0 && Character.isLetterOrDigit(tmp.charAt(0))) {
                    tmp = "-" + tmp;
                }
                res2.add(tmp);
                if (c=='-') {
                    tmp = "+";
                }else {
                    tmp = "-";
                }
            }else {
                tmp += c;
            }
        }
        res2.add(tmp);
        res.addAll(res2);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $640求解方程().solveEquation("2x+5-3+x=6+x-2"));
    }
}
