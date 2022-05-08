import java.util.ArrayList;
import java.util.List;

/**
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 * 其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次
 */
public class $442数组中重复数据 {

    // 1 ≤ a[i] ≤ n 这个条件，正好和数组的下标差1，可以按照数值来遍历数组
    // 题目的关键是依据数组中的值遍历数组下标
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[(nums[i] - 1) % n] += n;
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 2 * n) { // 抽屉原理 -> 将2件东西放到1个抽屉，必然有至少1个抽屉里的东西不少于2件
                ret.add(i+1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new $442数组中重复数据().findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
    }
}
