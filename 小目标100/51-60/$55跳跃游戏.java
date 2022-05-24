import java.util.HashSet;
import java.util.Set;

/**
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 */
public class $55跳跃游戏 {

    public boolean canJump(int[] nums) {
        if (nums.length==1) {
            return true;
        }
        if (nums[0]==0) {
            return false;
        }
        for (int i = nums.length-1; i >= 1; i--) {
            if (nums[i]==0) {
                boolean tmp = false;
                for (int j = i-1; j >=0; j--) {
                    if (i-j<nums[j]) {
                        tmp = true;
                        break;
                    }
                    if (i== nums.length-1 && i-j==nums[j]) {
                        tmp = true;
                    }
                }
                if (!tmp) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new $55跳跃游戏().canJump(new int[] {1,1,1,0}));
    }
}
