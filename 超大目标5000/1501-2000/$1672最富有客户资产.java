/**
 * 输入：accounts = [[1,2,3],[3,2,1]]
 * 输出：6
 * 解释：
 * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
 * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
 * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
 */
public class $1672最富有客户资产 {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int temp = 0;
            for (int j = 0; j < accounts[i].length; j++){
                temp += accounts[i][j];
            }
            if (max<temp) {
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(new $1672最富有客户资产().maximumWealth(accounts));
    }
}
