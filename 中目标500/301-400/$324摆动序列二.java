import java.util.Arrays;

/**
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 */
public class $324摆动序列二 {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int right = nums.length - 1,left = right/2;
        int[] temp = Arrays.copyOf(nums,nums.length);
        for(int i = 0; i < nums.length; i++){
            nums[i] = i % 2 == 0 ? temp[left--] :  temp[right--];
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new $324摆动序列二().wiggleSort(new int[] {1,5,1,1,6,4});
    }
}
