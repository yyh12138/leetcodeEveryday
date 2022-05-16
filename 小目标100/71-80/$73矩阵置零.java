import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 */
public class $73矩阵置零 {

    // 方法1、使用O(m+n)  
    // 方法2、使用O(1+1)=>使用两个标记，标记出第一行和第一列是否全是0，然后将矩阵内部情况标记在第一行和第一列中
    public void setZeroes(int[][] matrix) {
        int w = matrix[0].length;
        int h = matrix.length;
        Set<Integer> ws = new HashSet<>();
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j]==0) {
                    ws.add(j);
                    hs.add(i);
                }
            }
        }
        hs.forEach(height -> {
            for (int i = 0; i < w; i++) {
                matrix[height][i] = 0;
            }
        });
        ws.forEach(width -> {
            for (int i = 0; i < h; i++) {
                matrix[i][width] = 0;
            }
        });
    }

    public static void main(String[] args) {
        new $73矩阵置零().setZeroes(new int[][] {
                {1,1,1}, {1,0,1}, {1,1,1}
        });
    }
}
