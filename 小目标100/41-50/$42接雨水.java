import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class $42接雨水 {

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int sum = 0, max = 0;// 标记雨水高度
        while (left < right) {
            while (left < right && height[left] <= max) { // 只要小于高度，则代表可以接雨水
                sum += (max - height[left]);
                left++;
            }
            while (left < right && height[right] <= max) {
                sum += (max - height[right]);
                right--;
            }
            max = Math.min(height[left], height[right]);
        }
        return sum;
    }

    private int getRes(int res, List<Integer> trim) {
        for (int i = 0; i<trim.size()-1;) {
            int left = trim.get(i), right = 0;
            for (int j = i+1; j < trim.size(); j++) {
                right = trim.get(j);
                if (left<=right) {
                    res += (j-i-1)*left;
                    i = j;
                    break;
                }else {
                    res -= right;
                }
            }
        }
        return res;
    }

    // 减去最左和最右的0
    private List<Integer> trim(int[] height) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = height.length-1;
        for (; i < height.length; i++) {
            if (height[i]!=0) {
                break;
            }
        }
        for (; j>=0 ; j--) {
            if (height[j]!=0) {
                break;
            }
        }
        for (int k = i; k <=j; k++) {
            res.add(height[k]);
        }
        return res;
    }
    // 找到最后一个最大的柱子
    private int lastMax(List<Integer> trim) {
        int max = 0, maxIndex = 0;
        for (int i = 0; i < trim.size(); i++) {
            if (trim.get(i)>=max) {
                max = trim.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        System.out.println(new $42接雨水().trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
