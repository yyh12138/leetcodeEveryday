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
        return collect.get(0);
    }

    private void jp(int[] nums, int index, int time, List<Integer> times) {
        if (index==nums.length-1) {
            times.add(time);
        }else if (index>nums.length-1) {
            return;
        }else {
            for (int i = 1; i <= nums[index]; i++) {
                if (index+i<=nums.length) {
                    time++;
                    jp(nums, index+i, time, times);
                    time--;
                }else {
                    return;
                }
            }
        }
    }

    public int jump2(int[] nums) {
        /*
        贪心思想
        同样每次记录你能够跳到的最远距离 k
        0  1  2  3  4  5  6
        i
                 j
        假设从 0 起跳，最远能够跳到 3 位置，那么我们落脚到 1 2 3 位置，步数都是 1
        我们第 2 步可以从 1 2 3 之中任意一个点开始起跳，那么我们可以选择 1 2 3 中能跳得最远的点作为第二步的起跳点
        因为题目说了必定能够到达最后一个位置，这就是说
        0  1  2  3  4  5  6
        i
                 j
        不会存在 0 能够跳到的最远距离是 3，而 1 2 3 中能够跳到的最远距离也是 3，即无论怎么跳到跳不出 3 这个位置，这种情况是不存在的
        即 1 2 3 中必定存在一个位置能够跳出 3 这个位置，这样才能到达终点
        换成数组来看的话，即是不存在 nums = [3, 2, 1, 0, 1, 2, 3]，这种情况怎么跳都跳不出 3 位置

        我们使用 end 记录 0 位置的最远距离， 即 3
        使用 k 记录 1 2 3 位置能够跳的最远距离
        当 i 遍历到 end 的时候，我们需要将步数 step + 1，即开始一次新的起跳，然后将 end 更新为 k
        */
        int len = nums.length;
        if(len == 1){
            return 0;
        }
        //记录能够到达的最远距离
        int k = 0;
        //步数
        int step = 0;
        //记录上一步 step 跳的最远距离
        int end = 0;
        for(int i = 0; i < len; i++){
            //更新最大距离
            k = Math.max(k, i + nums[i]);
            /*
            0  1  2  3  4  5  6
            i
                     j
            比如第一步从 0 最远能够跳到 3, step = 1
            那么我们在遍历过程中发现在 1 2 3 中如果是 2 它的最远距离 k 能够跳到终点或终点后面，那么我们只需要 再加 1 步从 2 起跳就能到达终点
            因为我们是按照到 end 才进行步数 + 1，但是对于 2 位置来说，它的终点的 len - 1 之后的
            因此如果要提前返回的话，那么我们需要将 2 起跳的这一步加上，因此是 step + 1
            */
            if(k >= len - 1){
                return step + 1;
            }
            /*
            我们什么时候需要步数 + 1？
            当到达上一步的最远距离的时候，那么意味着我们需要进行一次新的起跳，那么步数 + 1
            并且更新最远距离
            */
            if(end == i){
                step++;
                end = k;
            }

        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new $45跳跃游戏二().jump2(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }
}
