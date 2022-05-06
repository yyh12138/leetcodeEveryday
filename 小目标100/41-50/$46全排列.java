import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class $46全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int n = nums.length;
        dfs(n, output, res, 0);
        return res;
    }

    private void dfs(int n, List<Integer> output, List<List<Integer>> res, int first) {
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
        System.out.println(new $46全排列().permute(new int[]{1,2,3}));
    }
}
