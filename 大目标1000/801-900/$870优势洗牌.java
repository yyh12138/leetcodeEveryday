import java.util.Arrays;

/**
 * nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 *
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 */
public class $870优势洗牌 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx = new Integer[n]; // nums2索引
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(idx, (i, j) -> nums2[i] - nums2[j]); //根据nums2数据升序，排序nums2(索引)
        int L = 0, R = n - 1; // nums2(索引)的左右指针
        for (int i : nums1) { // 遍历nums1
            if (i > nums2[idx[L]]) {
                nums2[idx[L++]] = i; // 可以满足 nums1[i] > nums2[i]
            } else {
                nums2[idx[R--]] = i; //丢到数组最后
            }
        }
        return nums2;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $870优势洗牌().advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11})));
    }
}
