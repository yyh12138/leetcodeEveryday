import java.util.ArrayList;
import java.util.List;

/**
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 * 输入：s = "011101"    输出：5
 * 将字符串 s 划分为两个非空子字符串的可行方案有：
 * 左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
 * 左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
 * 左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
 * 左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
 * 左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
 */
public class $1422分割字符串的最大得分 {

    public int maxScore(String s) {
        int numOf1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='1') {
                numOf1++;
            }
        }
        int max = 0, left = 0, right = numOf1;
        for (int i = 0; i < s.length()-1; i++) {
            char c = s.charAt(i);
            if (c=='0') {
                left++;
            }else {
                right--;
            }
            max = Math.max(max, left+right);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new $1422分割字符串的最大得分().maxScore("00"));
    }
}
