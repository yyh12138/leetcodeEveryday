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
        String output = "x=";
        int res = 0;
        int numOfDigit = 0, numOfX = 0;
        list = normalize(equation);
        // list = [+2x, +5, -3, +x, -6, -x, +2]
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.length()==0) {
                continue;
            }
            char type = str.charAt(str.length()-1);
            if (Character.isDigit(type)) {
                numOfDigit += Integer.parseInt(str);
            }else if (Character.isLetter(type)) {
                String t = str.split("x")[0];
                if (t.length()==1) {
                    t += "1";
                }
                numOfX += Integer.parseInt(t);
            }
        }
        if (numOfX==0) {
            if(numOfDigit==0) {
                return "Infinite solutions";
            }else {
                return "No solution";
            }
        }
        res = numOfDigit*(-1) / numOfX;
        return output+res;
    }

    private List<String> normalize(String equation) {
        List<String> res = new ArrayList<>();
        List<String> res2 = new ArrayList<>();

        String[] split = equation.split("=");
        String str1 = split[0], str2 = split[1];
        if (str1.charAt(0)!='-') {
            str1 = "+" + str1;
        }
        if (str2.charAt(0)!='-') {
            str2 = '+' + str2;
        }
        String tmp = "";
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (!Character.isLetterOrDigit(c)) { // 判断c为符号
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
        System.out.println(new $640求解方程().solveEquation("x=x-2"));
    }
}
