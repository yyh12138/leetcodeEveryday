import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释:
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 */
public class $812最大三角形面积 {

    public double largestTriangleArea(int[][] points) {
        double res = 0;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i+1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                for (int k = 0; k < points.length; k++) {
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    if (x1==x2&&x1==x3 || y1==y2&&y1==y3) {
                        continue;
                    }
                    double area = computeTriangleArea(x1, y1, x2, y2, x3, y3);
                    if (area>res) {
                        res = area;
                    }
                }
            }
        }
        return res;
    }
    // 三点构成的三角形面积
    public double computeTriangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (double)(x1*y2+x2*y3+x3*y1-x1*y3-x2*y1-x3*y2)/2;
    }
    // 向量叉积
    public int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }
    // 求众多点的凸包对应的点的集合 ->  Andrew算法
    public int[][] getConvexHull(int[][] points) {
        int n = points.length;
        if (n < 4) {
            return points;
        }
        /* 按照 x 大小进行排序，如果 x 相同，则按照 y 的大小进行排序 */
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        List<int[]> hull = new ArrayList<>();
        /* 求出凸包的下半部分 */
        for (int i = 0; i < n; i++) {
            while (hull.size() > 1 && cross(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points[i]);
        }
        int m = hull.size();
        /* 求出凸包的上半部分 */
        for (int i = n - 2; i >= 0; i--) {
            while (hull.size() > m && cross(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points[i]);
        }
        /* hull[0] 同时参与凸包的上半部分检测，因此需去掉重复的 hull[0] */
        hull.remove(hull.size() - 1);
        m = hull.size();
        int[][] hullArr = new int[m][];
        for (int i = 0; i < m; i++) {
            hullArr[i] = hull.get(i);
        }
        return hullArr;
    }

    public static void main(String[] args) {
        System.out.println(new $812最大三角形面积().largestTriangleArea(new int[][]{
                {0,0}, {0,1}, {1,0}, {0,2}, {2,0}
        }));
    }
}
