/**
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 *
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 */
public class $1175质数排列 {
    // res = 质数个数的全排列 * 非质数个数的全排列
    public int numPrimeArrangements(int n) {
        int sum = 0;
        if (n > 2){
            sum = getPrimeNum(n);
        }else {
            return 1;
        }
        long cur = 1L;
        for (int i = 2;i <= sum; i++){
            cur = (cur * i) % (1000000000 + 7);
        }
        for (int i = 2;i <= n - sum; i++){
            cur = (cur * i) % (1000000000 + 7);
        }
        return  (int)cur;
    }
    // 返回[1,n]中的质数个数
    public int getPrimeNum(int n){
        n += 1;
        int sum = 0;
        boolean[] bool = new boolean[n+1];
        for (int i = 2;i < n; i++){
            if (bool[i] == false){
                sum++;
                for (int j = 2; j*i < n; j++) {
                    bool[j*i] = true;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new $1175质数排列().numPrimeArrangements(5));
    }
}
