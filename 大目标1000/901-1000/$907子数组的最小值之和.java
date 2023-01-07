import java.util.Stack;

/**
 * 整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 *
 * 输入：arr = [3,1,2,4]    输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 */
public class $907子数组的最小值之和 {

    public int sumSubarrayMins(int[] A) {
        Stack<Integer> stack=new Stack<>();//用于临时存储下标以及A.length
        int ans=0;
        int mod=1000000007;
        for(int i=0;i<=A.length;i++){
            int num=i==A.length?0:A[i];//假定数组最后一个数后边有一个最小的数0
            while(!stack.isEmpty()&&A[stack.peek()]>num){
                int a=stack.pop();
                int b=stack.isEmpty()?-1:stack.peek();
                ans=(ans+A[a]*(i-a)*(a-b))%mod;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new $907子数组的最小值之和().sumSubarrayMins(new int[] {3,1,2,4}));
    }
}
