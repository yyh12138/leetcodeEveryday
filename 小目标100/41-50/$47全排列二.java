import java.util.*;
import java.util.stream.Collectors;

/**
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */

public class $47全排列二 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> output = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int n = nums.length;
        dfs(n, output, res, 0);
        return new ArrayList<>(res);
    }

    private void dfs(int n, List<Integer> output, Set<List<Integer>> res, int first) {
        if (first==n) {
            res.add(new ArrayList<>(output));
        }else {
            for (int i = first; i < n; i++) {
                Collections.swap(output, first, i);
                dfs(n, output, res, first+1);
                Collections.swap(output, first, i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new $47全排列二().permuteUnique(new int[]{1, 1, 2}));
    }
}
