import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 */
public class $398随机数索引 {

    List<Integer> res;

    public $398随机数索引(int[] nums) {
        res = Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    // 随机抽样
    public int pick(int target) {
        int c = 0;
        int index = 0;
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i)==target) {
                c++;
                if (new Random().nextInt(c)==0) { // [0, i)随机到整数0的概率为1/i，最终k个target抽到的概率为1/k
                    index = i;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        $398随机数索引 solution = new $398随机数索引(new int[]{1, 1, 1, 3, 3});
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
    }
}
