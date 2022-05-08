/**
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 */
public class $191位1个数 {

    // Integer.bitCount();
    // <<有符号左移   <<<无符号左移
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new $191位1个数().hammingWeight(00000000000000000000011111111101));
        System.out.println(1<<2);
        System.out.println(5 & (1<<2));
    }
}
