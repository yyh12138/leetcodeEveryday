/**
 * 给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。
 * f(x) 是 x! 末尾是 0 的数量
 */
public class $793阶乘后K个零 {

    public int preimageSizeFZF(int k) {
        long l = k-1, r = k*10L+1;
        while (l+1<r) {
            long m = (l+r)/2;
            long t = f(m);
            if (t==k) {
                return 5;
            }else if (t<k) {
                l = m;
            }else {
                r = m;
            }
        }
        return 0;
    }
    // 找n里有几个5
    long f(long n) {
        if (n==0) {
            return 0;
        }
        return n/5 + f(n/5);
    }

    public static void main(String[] args) {
        System.out.println(new $793阶乘后K个零().preimageSizeFZF(3));
    }
}
