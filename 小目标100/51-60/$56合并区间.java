import java.util.Arrays;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 输入：intervals = [  [1,3],[2,6],[8,10],[15,18]  ]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */

public class $56合并区间 {

    public int[][] merge(int[][] intervals) {
        int last = intervals[intervals.length-1][1];
        int[][] res = new int[intervals.length][2];
        boolean[] nums = new boolean[last+2];
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            for (int j = start; j <= end; j++) {
                nums[j] = true;
            }
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]) {
                int start = i;
                int end = i;
                for (int j = i+1; j < nums.length; j++) {
                    if (!nums[j]) {
                        end = j;
                        break;
                    }
                }
                res[index][0] = start;
                res[index][1] = end-1;
                index++;
                i += end - start;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new $56合并区间().merge(new int[][]{
                {1,3}, {3,6}, {8,10}, {15,18}
        })));
    }
}
