import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
 * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
 * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
 * 返回必须翻转的 0 的最小数目。
 *
 * 输入：grid = [[1,1,1,1,1],
 *              [1,0,0,0,1],
 *              [1,0,1,0,1],
 *              [1,0,0,0,1],
 *              [1,1,1,1,1]]
 * 输出：1
 */
public class $934最短的桥 {

    /**
     * 1. 过遍历找到grid中的1后进行广度优先搜索，此时可以得到第一座岛的位置集合，记为island，并将其位置全部标记为 −1。
     * 2. 随后从island中的所有位置开始进行广度优先搜索，当到达了任意的1时，即搜索到了第二个岛，搜索的层数就是答案。
     * @param grid
     * @return
     */
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        List<int[]> island = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 1
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        island.add(cell);
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dirs[k][0];
                            int ny = y + dirs[k][1];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1) {
                                queue.offer(new int[]{nx, ny});
                                grid[nx][ny] = -1;
                            }
                        }
                    }
                    for (int[] cell : island) {
                        queue.offer(cell);
                    }
                    // 2
                    int step = 0;
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                    if (grid[nx][ny] == 0) {
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    } else if (grid[nx][ny] == 1) {
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new $934最短的桥().shortestBridge(new int[][] {
                {1,1,1,1,1}, {1,0,0,0,1}, {1,0,1,0,1}, {1,0,0,0,1}, {1,1,1,1,1}
        }));
    }
}
