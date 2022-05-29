import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 */
public class $57插入区间 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] tmp = new int[1][2];
            tmp[0] = newInterval;
            return tmp;
        }

        List<int[]> res = new ArrayList<>();
        int newLeft = newInterval[0];
        int newRight = newInterval[1];
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            nums.add(intervals[i][0]);
            nums.add(intervals[i][1]);
        }
        int left = getLeftIndex(nums, newLeft, 0);
        int right = getLeftIndex(nums, newRight, 1);
        int[] record = new int[2];
        boolean lock = false;
        for (int i = 0; i < nums.size(); i++) {
            if (i==left) {
                lock = true;
                record[0] = nums.get(i);
            }
            if (i==right) {
                lock = false;
            }
            if (!lock) {
                record[i%2] = nums.get(i);
                if(i%2==1) {
                    res.add(record.clone());
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    // todo 特殊情况判断
    private int getLeftIndex(List<Integer> nums, int num, int flag) {
        if (flag==0) {
            for (int i = num; i >= 0; i--) {
                if(nums.contains(i)) {
                    return nums.indexOf(i);
                }
            }
        }else {
            for (int i = num; i <= nums.get(nums.size()-1); i++) {
                if (nums.contains(i)) {
                    if (i!=num) {
                        return nums.indexOf(i);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new $57插入区间().insert(new int[][]{

        }, new int[]{4,8})));
    }
}
