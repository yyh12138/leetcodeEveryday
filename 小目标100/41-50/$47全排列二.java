import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> collect = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
//        do {
//            List<Integer> tmp = new ArrayList<>();
//            for (int i = 0; i < collect.size(); i++) {
//                tmp.add(collect.get(i));
//            }
//            res.add(tmp);
//        }while ()

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $47全排列二().permuteUnique(new int[]{1, 1, 2}));
    }
}
