import java.util.Arrays;

/**
 * 输入: nums = [4,3,2,6]
 * 输出: 26
 * 解释:
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 */
public class $396旋转函数 {

    public int maxRotateFunction1(int[] nums) {
        int length = nums.length;
        if (length ==1) {
            return 0;
        }
        int res = F(0, length, nums);
        for (int i = 1; i < length; i++) {
            int tmp = F(i, length, nums);
            if (res<tmp) {
                res = tmp;
            }
        }
        return res;
    }
    private int F(int index, int length, int[] nums) {
        int fIndex = 0;
        for (int i = 0; i < length; i++) {
            fIndex += (index + i) % length * nums[i];
        }
        return fIndex;
    }


    // F(k+1)-F(k) = sum - nA[n-k-1]
    public int maxRotateFunction(int[] A) {
        int F = 0,sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum+= A[i];
            F += i*A[i];
        }
        int ans = F;
        for (int i = 1; i < A.length; i++) {
            F += (sum - A.length*A[A.length-i]);
            ans = Math.max(ans,F);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new $396旋转函数().maxRotateFunction(new int[] {1,2,3,4,5,6,7,8,9,10}));
    }
}

