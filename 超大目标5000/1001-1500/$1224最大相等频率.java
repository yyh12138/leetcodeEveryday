import java.util.Arrays;

/**
 * 给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
 *     从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 *
 * 输入：nums = [2,2,1,1,5,3,3,5]  输出：7
 * 解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数字都出现了两次。
 */
public class $1224最大相等频率 {

    int[] cnt = new int[100010]; // 数值i出现的次数
    int[] sum = new int[100010]; // 出现次数为i的数字数量
    public int maxEqualFreq(int[] nums) {
//        Arrays.fill(cnt, 0);
//        Arrays.fill(sum, 0);
        int max = 0; // cnt[i]的最大值
        int ans = 0; // 最大前缀数组长度
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i], cur = ++cnt[t], len = i+1;
            sum[cur]++;
            sum[cur-1]--;
            max = Math.max(max, cur);
            if(max==1) {
                ans = len;
            }
            if (max*sum[max]+1 == len) { // 有一个数单独出现了一次
                ans = len;
            }
            if ((max-1)*(sum[max-1]+1)+1 == len) { // 出现次数为max的数值只有一个，其余出现次数均为 max-1。对其删除一次后即满足要求
                ans = len;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new $1224最大相等频率().maxEqualFreq(new int[] {2,2,1,1,5,3,3,5}));
    }
}
