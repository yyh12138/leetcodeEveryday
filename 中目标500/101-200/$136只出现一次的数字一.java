import java.util.*;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class $136只出现一次的数字一 {

    // 异或
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        System.out.println(new $136只出现一次的数字一().singleNumber(new int[]{4,1,2,1,2}));
    }
}
