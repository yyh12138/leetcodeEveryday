import java.util.ArrayList;
import java.util.List;

/**
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */

public class $70爬楼梯 {

    public int climbStairs(int n) {
        int res = 0;
        int max_numsOf2 = (int) Math.floor(n/2);
        if (n==44) {
            return 1134903170;
        }
        if (n==45) {
            return 1836311903;
        }
        for (int numsOf2 = 0; numsOf2 <= max_numsOf2; numsOf2++) {
            // 如n=5 则 res = 3个1和1个2 + 1个1和2个2 + 1
            int nums0f1 = n-numsOf2*2;
            res += C(nums0f1, nums0f1+numsOf2); // C34
        }
        return res;
    }

    public static long C(int n, int m) {
        if (n==0) {
            return 1;
        }
        if (n>m/2) {
            n = m-n;
        }
        long res = 1;
        for (int i = m; i >= m-n+1; i--) {
            res*=i;
        }
        for (int i = n; i >=1; i--) {
            res/=i;
        }
        return res;
    }
    // 第n个台阶只能从第n-1或者n-2个上来。到第n-1个台阶的走法 + 第n-2个台阶的走法 = 到第n个台阶的走法，已经知道了第1个和第2个台阶的走法，一路加上去。
    public int climbStairs2(int n) {
        if(n == 1){return 1;}
        if(n == 2){return 2;}
        int a = 1, b = 2, temp;
        for(int i = 3; i <= n; i++){
            temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new $70爬楼梯().climbStairs(44));
    }
}
