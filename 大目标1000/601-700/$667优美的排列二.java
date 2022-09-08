import java.util.Arrays;

/**
 * 输入：n = 3, k = 1    输出：[1, 2, 3]
 * 解释：[1, 2, 3] 包含 3 个范围在 1-3 的不同整数，并且 [1, 1] 中有且仅有 1 个不同整数：1
 *
 * 包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件：
 * 假设该列表是 answer=[a1, a2, a3, ... , an] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数。
 */
public class $667优美的排列二 {
    // 找规律
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int numk = k + 1;
        int numTemp = 1;
        //下标段[0, k]中，偶数下标填充[1,2,3..]
        for (int i = 0; i <= k; i += 2) {
            ans[i] = numTemp++;
        }
        //下标段[0, k]中，奇数下标填充[k + 1, k, k - 1...]
        for (int i = 1; i <= k; i += 2) {
            ans[i] = numk--;
        }
        //下标段[k + 1, n - 1]都是顺序填充
        for (int i = k + 1; i < n; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $667优美的排列二().constructArray(3, 1)));
    }
}
