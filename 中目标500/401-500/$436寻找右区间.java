import java.util.Arrays;
import java.util.Collections;

/**
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1,0,1]
 * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 *
 */
public class $436寻找右区间 {

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            int startJMin = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int endI = intervals[i][1];
                int startJ = intervals[j][0];
                if (startJ>=endI) {
                    if (res[i]==-1) {
                        res[i] = j;
                        startJMin = startJ;
                    }else {
                        if (startJMin>startJ) {
                            startJMin = startJ;
                            res[i] = j;
                        }
                    }
                }
            }
        }
        return res;
    }

    // 二分查找
    public int[] findRightInterval2(int[][] intervals) {
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, (o1, o2) -> o1[0] - o2[0]);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            int target = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (startIntervals[mid][0] >= intervals[i][1]) {
                    target = startIntervals[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = target;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $436寻找右区间().findRightInterval(new int[][]{
                {3, 4}, {2, 3}, {1, 2}
        })));
    }
}
