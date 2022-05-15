import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class $77组合 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> kwords = new ArrayList<>();
        List<Integer> remain = new ArrayList<>();
        for (int i = 1; i <= n; i++) { remain.add(i); }
        dfs(res, kwords, remain, 0, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> kwords, List<Integer> remain, int first, int k) {
        if (kwords.size()==k) {
            res.add(kwords);
            return;
        }else {
            for (int i = first; i < remain.size(); i++) {

            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new $77组合().combine(4, 2));
    }
}
