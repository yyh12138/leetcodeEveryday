/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 */

public class $231幂运算 {
    // 10
    public boolean isPowerOfTwo(int n) {
        double tmp = n;
        while (tmp>=1) {
            if (tmp==1) {
                return true;
            }
            tmp =  tmp/2.0;
            if (tmp%(int)tmp != 0) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new $231幂运算().isPowerOfTwo(16));
    }
}
