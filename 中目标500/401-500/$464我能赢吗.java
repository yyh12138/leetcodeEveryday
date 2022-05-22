import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入：maxChoosableInteger = 10, desiredTotal = 11
 * 输出：false
 * 解释：
 * 无论第一个玩家选择哪个整数，他都会失败。
 * 第一个玩家可以选择从 1 到 10 的整数。
 * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
 * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
 * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
 *
 */
public class $464我能赢吗 {

    Boolean[] dp;
    int maxChoosableInteger;
    Map<Integer, Boolean> memo = new HashMap();
    boolean[] vis;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //最大的可以选的数(maxChoosableInteger)大于等于最终目标数(desiredTotal),A先抽，直接拿desiredTotal，胜出
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        //[1, maxChoosableInteger]之间的总数的和小于最终目标数(desiredTotal),A和B将数选完也不能凑成(desiredTotal),A赢不了，返回false
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        this.maxChoosableInteger = maxChoosableInteger;
        dp = new Boolean[1 << maxChoosableInteger];
        return dfs(desiredTotal, 0);
    }
    /**
     * 回溯+状态压缩(通过二进制，减少时间复杂度)
     * @param remain 当前离达成目标的原始desiredTotal还差多少
     * @param state        当前从1到maxChoosableInteger之间的每个数被选中的状态，在二进制下，1为选中，0为未选中
     * @return
     */
    private boolean dfs(int remain, int state) {
        //如果该state被标记过，返回
        if (dp[state] != null) {
            return dp[state];
        }
        //从 1 到 maxChoosableInteger 判断每一位是否被选中过
        for (int i = 1; i <= maxChoosableInteger; i++) {
            //当前位 需要判断下当前位是否是1（二进制下）
            int cur = 1 << (i - 1);
            if ((cur & state) == 0) {//当前位不是1是0，表示当前位可以选
                //case1: 选中当前的数i后，可以达成最终的目标
                //case2: 选中当前的数i后，暂时不能达成目标，但是对手最终不能达成目标，意味着当前玩家最终可以达成目标
                //       cur | state 表示将当前数i选中 送到下一轮的状态中
                if (remain - i <= 0 || !dfs(remain - i, cur | state)) {
                    return dp[state] = true;
                }
            }
        }
        return dp[state] = false;
    }

    public boolean canIWin2(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        vis = new boolean[maxChoosableInteger + 1];
        return helper(desiredTotal);
    }

    private boolean helper(int desiredTotal) {
        if (desiredTotal <= 0) return false;
        int key = format(vis);
        if (!memo.containsKey(key)) {
            //遍历vis中的数，尝试没有被选中的
            for (int i = 1; i < vis.length; i++) {
                if (!vis[i]) {//i没有被选择
                    vis[i] = true;//标记
                    // 当前i被选中，留给对手的desiredTotal - i的空间，但是对手没法胜出
                    if (!helper(desiredTotal - i)) {
                        memo.put(key, true);
                        vis[i] = false;//恢复
                        return true;
                    }
                    vis[i] = false;//恢复
                }
            }
            memo.put(key, false);
        }
        return memo.get(key);
    }

    // 遍历vis数组，每一位true的设置为1，相当于压缩
    private int format(boolean[] vis) {
        int res = 0;
        for (boolean b : vis) {
            res <<= 1;
            if (b) res |= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $464我能赢吗().canIWin(10, 11));
    }
}
