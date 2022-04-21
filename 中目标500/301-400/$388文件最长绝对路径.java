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

    // 动态规划
    public int lengthLongestPath2(String input) {
        if(input==null||input.length()==0) {
            return 0;
        }
        String[] words=input.split("\n");
        int[] pathLens=new int[words.length+1];// pathLens[i]存放地i层次的最后面的元素的路径长度
        pathLens[0]=-1;// 层次最少是1，为了统一dp操作（具体看下面循环体），取pathLens[0]=-1
        int ans=0;
        // 自左向右，dp
        for(String word:words){
            int level=word.lastIndexOf('\t')+1+1;//层次计算
            int nameLen=word.length()-(level-1);//计算名字长度
            // word的父文件夹必定目前是level-1层次的最后一个，因此pathLens[level-1]就是父文件夹路径长度
            // 这个word必然是目前本层次的最后一个，因此需要刷新pathLens[level],+1是因为要加一个'\'
            pathLens[level]=pathLens[level-1]+1+nameLen;
            // 如果是文件，还需要用路径长度刷新ans
            if(word.contains(".")) {
                ans=Math.max(ans,pathLens[level]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(input);
        System.out.println(new $388文件最长绝对路径().lengthLongestPath(input));
    }
}
