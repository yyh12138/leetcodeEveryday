import java.util.Arrays;

/**
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class $34数组查找索引 {

    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[2];

        if(nums.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return  result;
        }
        result[0] = findFirst(nums, nums.length, target);
        result[1] = findLast(nums, nums.length, target);
        return result;
    }

    public int findFirst(int [] a, int len, int key)
    {
        if (len < 1) {
            return - 1;
        }
        int low = 0;
        int high = len - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            if (a[mid] == key && (mid - 1 < 0 || a[mid - 1] != key)) {
                return mid;
            }
            else if (a[mid] >= key) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public int findLast(int [] a, int len, int key) {
        if (len < 1) {
            return - 1;
        }
        int low = 0;
        int high = len - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            if (a[mid] == key && (mid + 1 >= len || a[mid + 1] != key)) {
                return mid;
            }
            else if (a[mid] <= key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $34数组查找索引().searchRange(new int[]{5, 7, 7, 8, 8, 8, 8, 8, 10}, 8)));
    }
}
