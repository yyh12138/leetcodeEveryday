/**
 * 二进制字符串s，该字符串不含前导零
 * 如果s包含零个或一个由连续的 '1' 组成的字段，返回true。否则返回false
 * 如果s中由连续若干个 '1' 组成的字段数量不超过1，返回true。否则返回false
 *
 * 输入：s = "1001"    输出：false
 * 解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
 */
public class $1784检查二进制字符串字段 {

    public boolean checkOnesSegment(String s) {
        int numsOf1s = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char num = s.charAt(i);
            if (num=='1') {
                flag = true;
            }
            if (flag && num=='0') {
                flag = false;
                numsOf1s++;
            }
        }
        if (flag) {
            numsOf1s++;
        }

        return numsOf1s<=1;
    }

    public static void main(String[] args) {
        System.out.println(new $1784检查二进制字符串字段().checkOnesSegment("11000"));
    }
}
