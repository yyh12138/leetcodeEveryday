import java.util.ArrayList;
import java.util.List;

/**
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]    输出：true
 * 解释：group1 [1,4], group2 [2,3]
 *
 * n个人（编号1, 2, ..., n），把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 给定整数n和数组dislikes其中dislikes[i]=[ai, bi]表示不允许将编号为ai和bi的人归入同一组。可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 */
public class $886可能的二分法 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];// dislikes集合
        for (int i = 0; i <= n; ++i) {
            g[i] = new ArrayList<>();
        }
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; ++i) {
            if (color[i] == 0 && !dfs(i, 1, color, g)) {
                return false;
            }
        }
        return true;
    }
    // nowcolor = {1, 2}
    public boolean dfs(int curnode, int nowcolor, int[] color, List<Integer>[] g) {
        color[curnode] = nowcolor;
        for (int nextnode : g[curnode]) {
            if (color[nextnode] != 0 && color[nextnode] == color[curnode]) {
                return false;
            }
            if (color[nextnode] == 0 && !dfs(nextnode, 3^nowcolor, color, g)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new $886可能的二分法().possibleBipartition(4, new int[][] {{1,2},{1,3},{2,4}}));
    }
}
