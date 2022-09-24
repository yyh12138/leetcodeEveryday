import java.util.Arrays;

/**
 * 长度为n的循环数组code以及一个密钥k。为了获得正确的密码，你需要替换掉每一个数字。所有数字会同时被替换。
 *     如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 *     如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 *     如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1].
 *
 * 输入：code = [5,7,1,4], k = 3    输出：[12,10,16,13]
 * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
 */
public class $1652拆炸弹 {

    public int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] res = new int[length];
        if(k==0) {
            return res;
        }else if (k>0) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < k; j++) {
                    res[i] += code[(i+j+1)%length];
                }
            }
            return res;
        }else {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < -k; j++) {
                    int offset;
                    if (i-j-1<0) {
                        offset = length+i-j-1;
                    }else {
                        offset = i-j-1;
                    }
                    res[i] += code[offset];
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $1652拆炸弹().decrypt(new int[] {2,4,9,3},-2)));
    }
}
