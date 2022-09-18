import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * nxn二进制矩阵grid。最多只能将一格 0 变成 1
 * grid 中最大的岛屿面积是多少？岛屿由一组上、下、左、右四个方向相连的 1 形成。
 */
public class $827最大人工岛 {

    /**
     * 首先跑一次dfs找到所有的联通块，统计每个点所属的联通块标号以及该联通块下点的个数。
     * 之后枚举所有为0的点，拓展四周为1的点，进行合并判断。
     */
    static int[] d = {0, -1, 0, 1, 0};

    public int largestIsland(int[][] grid) {
        int n = grid.length, res = 0;
        int[][] tag = new int[n][n];
        Map<Integer, Integer> area = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && tag[i][j] == 0) {
                    int t = i * n + j + 1; // 唯一标识
                    area.put(t, dfs(grid, i, j, tag, t));
                    res = Math.max(res, area.get(t));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int z = 1;
                    Set<Integer> connected = new HashSet<Integer>();
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k], y = j + d[k + 1];
                        if (!valid(n, x, y) || tag[x][y] == 0 || connected.contains(tag[x][y])) {
                            continue;
                        }
                        z += area.get(tag[x][y]);
                        connected.add(tag[x][y]);
                    }
                    res = Math.max(res, z);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y, int[][] tag, int t) {
        int n = grid.length, res = 1;
        tag[x][y] = t;
        for (int i = 0; i < 4; i++) {
            int x1 = x + d[i], y1 = y + d[i + 1];
            if (valid(n, x1, y1) && grid[x1][y1] == 1 && tag[x1][y1] == 0) {
                res += dfs(grid, x1, y1, tag, t);
            }
        }
        return res;
    }

    public boolean valid(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        System.out.println(new $827最大人工岛().largestIsland(new int[][] {
                {1, 0, 0}, {0, 1, 1}, {0, 1, 0}
        }));
    }
}
