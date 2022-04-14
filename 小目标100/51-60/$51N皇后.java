import java.util.*;

/**
 *  输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 */
public class $51N皇后 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals_left = new HashSet<>();// 左对角线
        Set<Integer> diagonals_right = new HashSet<>();// 右对角线
        dfs(res, queens, n, 0, columns, diagonals_left, diagonals_right);
        return res;
    }

    private void dfs(List<List<String>> res, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals_left, Set<Integer> diagonals_right) {
        if (row==n) {
            // 当遍历至最后一行，将一种解法存入
            List<String> board = generateBoard(queens, n);
            res.add(board);
        }else {
            for (int i=0; i<n; i++) {
                if(columns.contains(i)) {
                    continue;
                }
                int diagonal_left = row-i;
                if (diagonals_left.contains(diagonal_left)) {
                    continue;
                }
                int diagonal_right = row+i;
                if (diagonals_right.contains(diagonal_right)) {
                    continue;
                }
                // 经过三轮排除，确定第row行的queen所在列
                queens[row] = i;
                // 将已选中的单元格加入到列表
                columns.add(i);
                diagonals_left.add(diagonal_left);
                diagonals_right.add(diagonal_right);
                dfs(res, queens, n, row+1, columns, diagonals_left, diagonals_right);
                // 剪枝
                queens[row] = -1;
                columns.remove(i);
                diagonals_left.remove(diagonal_left);
                diagonals_right.remove(diagonal_right);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i=0; i<n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }


    public static void main(String[] args) {
        $51N皇后 N皇后 = new $51N皇后();
        N皇后.solveNQueens(4).stream().forEach(System.out::println);
    }
}
