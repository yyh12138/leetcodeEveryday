import java.util.Arrays;

/**
 * 输入：s = "loveleetcode", c = "e"
 * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
 * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
 * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
 * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
 * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
 */
public class $821字符最短距离 {

    public int[] shortestToChar(String s, char c) {
        int [] res = new int[s.length()];
        Arrays.fill(res, -1);
        int last_index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==c) {
                res[i] = 0;
                int tmp = 1;
                for (int j = i-1; j >= last_index; j--) {
                    if (res[j]==-1 || res[j]>tmp) {
                        res[j] = tmp;
                        tmp++;
                    }
                }
                last_index = i;
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i]==0) {
                int tmp = 1;
                for (int j = i+1; j < res.length; j++) {
                    if (res[j]==0) {
                        break;
                    }
                    if (res[j]==-1 || res[j]>tmp){
                        res[j] = tmp;
                    }
                    tmp++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $821字符最短距离().shortestToChar("aaba", 'b')));
    }
}
