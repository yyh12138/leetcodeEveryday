import java.util.*;

/**
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class $40数组总和二 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> record = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, record, candidates, target, 0, 0);
        return new ArrayList<>(res);
    }

    private void dfs(Set<List<Integer>> res, List<Integer> now, int[] candidates, int target, int index, int sum) {
        if (target==sum) {
            res.add(new ArrayList<>(now));
        }else{
            boolean flag = false;
            for (int i = index; i < candidates.length; i++) {
                sum += candidates[i];
                now.add(candidates[i]);
                if (target>=sum) {
                    dfs(res, now, candidates, target, i+1, sum);
                }else {
                    flag = true;
                }
                now.remove(now.size()-1);
                sum -= candidates[i];
                if (flag) {
                    flag = false;
                    break;
                }
            }
        }
    }
    // 1 1 2 5 6 7 10
    public static void main(String[] args) {
        List<List<Integer>> lists = new $40数组总和二().combinationSum2(new int[]{1,2,3,4,5,6,7,8}, 8);
        for (List<Integer> list : lists) {
            for (int num : list) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
