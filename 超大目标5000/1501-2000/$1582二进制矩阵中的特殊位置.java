/**
 * 输入：mat = [[1,0,0],
 *             [0,0,1],
 *             [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 *
 * 返回 矩阵 mat 中特殊位置的数目 。
 * 特殊位置定义：
 * 如果 mat[i][j] == 1 并且第i行和第j列中的所有其他元素均为 0（行和列的下标均从0开始），则位置 (i, j) 被称为特殊位置。
 */
public class $1582二进制矩阵中的特殊位置 {

    public int numSpecial(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int n = mat[i][j];
                if (n==1 && iRowIs0(i, j, mat) && jColIs0(i, j, mat)) {
                    res++;
                }
            }
        }

        return res;
    }

    private boolean jColIs0(int i, int j, int[][] mat) {
        for (int k = 0; k < mat.length; k++) {
            if (k!=i && mat[k][j]!=0) {
                return false;
            }
        }

        return true;
    }

    private boolean iRowIs0(int i, int j, int[][] mat) {
        for (int k = 0; k < mat[0].length; k++) {
            if (k!=j && mat[i][k]!=0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new $1582二进制矩阵中的特殊位置().numSpecial(new int[][]{
                {1,0,0}, {0,0,1}, {1,0,0}
        }));
    }
}
