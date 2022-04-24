import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：n = 22
 * 输出：2
 * 解释：22 的二进制是 "10110" 。
 * 在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
 * 第一对相邻的 1 中，两个 1 之间的距离为 2 。
 * 第二对相邻的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 */
public class $868二进制间距 {

    public int binaryGap2(int n) {
        int last = -1, ans = 0;
        for (int i = 0; n != 0; ++i) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return ans;
    }

    public int binaryGap(int n) {
        String binaryString = "0"+Integer.toBinaryString(n)+"0";
        List<String> split = Arrays.stream(binaryString.split("1")).sorted().collect(Collectors.toList());

        return split.get(split.size()-1).length();
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(8));
        System.out.println(new $868二进制间距().binaryGap(8));
    }

}
