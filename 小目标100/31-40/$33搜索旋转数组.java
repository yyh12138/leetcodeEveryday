import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 */

public class $33搜索旋转数组 {

    public int search(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return list.indexOf(target);
    }

    // 如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的，我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
    public int search2(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            else{
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new $33搜索旋转数组().search(new int[] {4,5,6,7,0,1,2}, 9));
    }
}
