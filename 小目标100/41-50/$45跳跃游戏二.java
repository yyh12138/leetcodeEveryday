import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 */

public class $45跳跃游戏二 {

    public int jump(int[] nums) {
        List<Integer> times = new ArrayList<>();
        jp(nums, 0, 0, times);
        List<Integer> collect = times.stream().sorted().collect(Collectors.toList());
        return collect.get(collect.size()-1);
    }

    private void jp(int[] nums, int index, int time, List<Integer> times) {
        if (index==nums.length-1) {
            times.add(time);
        }else {
            for (int i = 1; i <= nums[index]; i++) {
                if (index+i<=nums.length) {
                    jp(nums, index+i, ++time, times);
                }else {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new $45跳跃游戏二().jump(new int[]{2,3,1,1,4}));
    }
}
