import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 */
public class $39组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            ArrayList<Integer> now = new ArrayList<>();
            now.add(candidates[i]);
            dfs(res, candidates, target, i, now, candidates[i]);
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 递归+剪枝
     * @param res 最终结果集
     * @param candidates 整数列表
     * @param target 目标值
     * @param index 当前分支最小值位置
     * @param now 当前整数组合
     * @param sum 当前整数组合值
     */
    private void dfs(List<List<Integer>> res, int[] candidates, int target, int index, List<Integer> now, int sum) {
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            now.add(candidates[i]);
            if (target<sum) {
                if (now.size()>0) {
                    now.remove(candidates[i]);
                    sum -= candidates[i];
                }
            }
            if (target==sum) {
                res.add(now);
                break;
            }
            if (target>sum) {
                dfs(res, candidates, target, i, now, sum);
            }


        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        new $39组合总和().combinationSum(candidates, target).forEach(System.out::println);
    }
}
