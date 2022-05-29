import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 */
public class $57插入区间 {

    public int[][] insert2(int[][] intervals, int[] newInterval) {
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
        return nums.size()+1;
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] tmp = new int[1][2];
            tmp[0] = newInterval;
            return tmp;
        }
        int[][] t = new int[intervals.length+1][2];
        System.arraycopy(intervals, 0, t, 0, t.length - 1);
        t[intervals.length] = newInterval;
        Arrays.sort(t, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < t.length; ++i) {
            int L = t[i][0], R = t[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new $57插入区间().insert(new int[][]{
                {0,1}, {3,7}
        }, new int[]{4,8})));
    }
}
