/**
 * 输入：n = 00000010100101000001111010011100
 * 输出：964176192 (00111001011110000010100101000000)
 * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 */
public class $190颠倒二进制位 {

    // n为无符号二进制
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder(n+"");
        sb.reverse();
        return Integer.valueOf(String.valueOf(sb), 2);
    }

    public int reverseBits2(int n) {
        int a=0;
        for(int i=0;i<=31;i++){
            a = a + ((1&(n>>i))<<(31-i));
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new $190颠倒二进制位().reverseBits(11100));
    }
}
