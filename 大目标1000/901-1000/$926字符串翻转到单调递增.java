/**
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 * 返回使 s 单调递增的最小翻转次数。
 */
public class $926字符串翻转到单调递增 {

    public int minFlipsMonoIncr(String s) {
        // 0 0 0 1 0 1 1  -> 1
        // 遍历字符串找到一个分界点，使得该分界点之前1的个数和分界点之后0的个数之和最小，把分界点之前的1变成0，之后的0变成1
        int pre1 = 0, aft0 = get0Nums(s,0);
        int res = pre1 + aft0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='0') {
                aft0--;
            }
            int tmp = pre1 + aft0;
            if (tmp<res) {
                res = tmp;
            }
            if (c=='1') {
                pre1++;
            }
        }
        return res;
    }

    private int get0Nums(String s, int index) {
        int res = 0;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i)=='0') {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $926字符串翻转到单调递增().minFlipsMonoIncr("0001011"));//1
    }
}
