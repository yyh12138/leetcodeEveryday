import java.util.Arrays;
import java.util.Collections;

/**
 * 需要按照 非递减 的高度顺序排成一行。返回满足 heights[i] != expected[i] 的 下标数量 。
 *
 * 输入：heights = [1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度：[1,1,4,2,1,3]
 * 预期：[1,1,1,2,3,4]
 * 下标 2 、4 、5 处的学生高度不匹配。
 *
 */
public class $1051高度检查器 {

    public int heightChecker(int[] heights) {
        int res = 0;
        int[] excepted = heights.clone();
        Arrays.sort(excepted);
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int e = excepted[i];
            if (h!=e) {
                res++;
            }
        }
        return res;
    }
    // 计数排序
    public int heightChecker2(int[] heights) {
        int m = Arrays.stream(heights).max().getAsInt();
        int[] cnt = new int[m + 1];
        for (int h : heights) {
            ++cnt[h];
        }

        int idx = 0, ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= cnt[i]; ++j) {
                if (heights[idx] != i) {
                    ++ans;
                }
                ++idx;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new $1051高度检查器().heightChecker2(new int[] {1,1,4,2,1,3}));
    }
}
