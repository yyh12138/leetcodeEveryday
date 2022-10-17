import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 *     你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 *     你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 *     一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 *
 * 输入：fruits = [0,1,2,2]    输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 */
public class $904水果成篮 {

    // 求只包含两种元素的最长连续子序列
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0, ans = 0;
        int b1 = fruits[left], b2 = fruits[right];
        while (right<fruits.length) {
            if (fruits[right]==b1 || fruits[right]==b2) {
                ans = Math.max(ans, right-left+1);
                right++;
            }else {
                left = right-1;
                b1 = fruits[left];
                while (left>=1 && fruits[left-1]==b1) {
                    left--;
                }
                b2 = fruits[right];
                ans = Math.max(ans, right-left+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new $904水果成篮().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
