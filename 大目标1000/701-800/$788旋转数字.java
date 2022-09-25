import java.util.Arrays;
import java.util.List;

/**
 * 称一个数X为好数, 如果它的每位数字逐个地被旋转180度后，我们仍可以得到一个有效的，且和X不同的数。要求每位数字都要被旋转。
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * 有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数
 *
 * 输入: 10   输出: 4
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。注意1和10不是好数, 因为他们在旋转之后不变。
 */
public class $788旋转数字 {
    // 0   1   2   3   4   5   6   7   8   9
    // 0   1   5   ×   ×   2   9   ×   8   6
    List<Integer> valid = Arrays.asList(2, 5, 6, 9);
    List<Integer> invalid = Arrays.asList(3, 4, 7);
    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            boolean hasValid = false;
            boolean hasInvalid = false;
            int num = i;
            while (num>0) {
                int j = num%10;
                if (invalid.contains(j)) {
                    hasInvalid = true;
                    break;
                }
                if (!hasValid && valid.contains(j)) {
                    hasValid = true;
                }
                num /= 10;
            }
            if (hasValid && !hasInvalid) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $788旋转数字().rotatedDigits(40));
    }
}
