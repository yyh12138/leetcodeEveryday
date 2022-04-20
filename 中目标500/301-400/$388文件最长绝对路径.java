import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入：input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 * 输出：32
 * 解释：存在两个文件：
 * "dir/subdir1/file1.ext" ，路径长度 21
 * "dir/subdir2/subsubdir2/file2.ext" ，路径长度 32
 * 返回 32 ，因为这是最长的路径
 */

public class $388文件最长绝对路径 {

    private static int max = 0;
    // 获取文件层级
    private static int cntLev(String s){
        int ans = 0;
        for(char c : s.toCharArray()){
            if(c != '\t') {
                continue;
            }
            ans++;
        }
        return ans;
    }

    /**
     * @param ss 目录
     * @param i 当前正在遍历的文件下标
     * @param lev 当前文件层级
     * @param sum 当前最大绝对路径
     */
    private static void dfs(String[] ss,int i,int lev,int sum){
        int n = ss.length;
        if(i >= n) {
            return;
        }
        for(int j = i; j < n; j++){
            int tlev = cntLev(ss[j]);
            if(tlev == lev){
                if(ss[j].contains(".")){
                    if(sum + ss[j].length() - lev > max) {
                        max = sum + ss[j].length() - lev;
                    }
                }else{
                    dfs(ss,j + 1,lev + 1, sum + ss[j].length() - lev + 1);
                }
            }else { // dfs超出当前文件夹下时不能递归统计文件夹下问题
                System.out.println();
                break;
            }
        }
    }
    public int lengthLongestPath(String input) {
        String[] ss = input.split("\n");
        dfs(ss,0,0,0);
        return max;
    }
    // 获取层级数量
    private int getN(String input) {
        int n = 1;
        for (int i = 0; i < input.length()-1; i++) {
            int tmp = 1;
            if (input.charAt(i)=='\n') {
                for (int j = i+1; j < input.length(); j++) {
                    if (input.charAt(j)=='\t') {
                        tmp++;
                    }else {
                        if (n<tmp) {
                            n=tmp;
                        }
                        break;
                    }
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(input);
        System.out.println(new $388文件最长绝对路径().lengthLongestPath(input));
    }
}
