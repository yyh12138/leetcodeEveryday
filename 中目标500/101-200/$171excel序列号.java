import java.util.HashSet;
import java.util.Set;

/**
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 输入: columnTitle = "AB"
 * 输出: 28
 */
public class $171excel序列号 {

    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int weight = (int) Math.pow(26, columnTitle.length()-1-i);
            res += (columnTitle.charAt(i)-64) * weight;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $171excel序列号().titleToNumber("ZY"));
    }
}
