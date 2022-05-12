/**
 * 输入：strs = ["cba","daf","ghi"]
 * 输出：1
 * 解释：网格示意如下：
 *   cba
 *   daf
 *   ghi
 * 列 0 和列 2 按升序排列，但列 1 不是，所以只需要删除列 1 。
 */
public class $944删列造序 {

    public int minDeletionSize(String[] strs) {
        int col = strs[0].length();
        String[] colString = new String[col];
        Boolean[] colBoolen = new Boolean[col];
        int res = 0;
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < col; j++) {
                char c = strs[i].charAt(j);// 第i个字符串的第j个字符
                if (i==0) {
                    colString[j] = ""+c;
                    colBoolen[j] = true;
                }
                if (i!=0 && colBoolen[j]){
                    if (colString[j].charAt(i-1)<=c) {
                        colString[j] += c;
                    }else {
                        res++;
                        colBoolen[j] = false;
                    }
                }
            }
        }
        return res;
    }
    public int minDeletionSize2(String[] strs) {
        int row = strs.length;
        int col = strs[0].length();
        int ans = 0;
        for (int j = 0; j < col; ++j) {
            for (int i = 1; i < row; ++i) {
                if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new $944删列造序().minDeletionSize(new String[]{"rrjk","furt","guzm"}));
    }
}
