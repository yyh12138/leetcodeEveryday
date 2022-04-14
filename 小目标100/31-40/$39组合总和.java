import java.util.*;
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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        Set<List<Integer>> temp = new HashSet<>();
        for (List<Integer> r: res) {
            temp.add(r.stream().sorted().collect(Collectors.toList()));
        }
        res.clear();
        res.addAll(temp);
        return res;
    }

    /**
     * 递归+剪枝
     * @param candidates 整数列表
     * @param target 目标值
     * @param index 当前分支最小值位置
     * @param now 当前整数组合
     * @param sum 当前整数组合值
     */
    private void dfs(int[] candidates, int target, int index, List<Integer> now, int sum) {
        if (target==sum) {
            res.add(new ArrayList<>(now));
        }else{
            for (int i = 0; i < candidates.length; i++) {
                sum += candidates[i];
                now.add(candidates[i]);
                if (target>=sum) {
                    dfs(candidates, target, i, now, sum);
                }
                now.remove(now.size()-1);
                sum -= candidates[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2};
        int target = 1;
        new $39组合总和().combinationSum(candidates, target).forEach(System.out::println);
    }
}
