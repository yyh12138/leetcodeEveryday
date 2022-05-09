import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 *     如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
 *     如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 *
 * 输入：s = "IDID"
 * 输出：[0,4,1,3,2]
 */

public class $942递增字符串匹配 {

    public int[] diStringMatch(String s) {
        int[] perm = new int[s.length()+1];
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < s.length()+1; i++) {
            tmp.add(i);
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='I') { // perm[i] < perm[i+1]
                perm[i] = tmp.get(0);
                tmp.remove(0);
            }else { // perm[i] > perm[i+1]
                perm[i] = tmp.get(tmp.size()-1);
                tmp.remove(tmp.size()-1);
            }
        }
        perm[s.length()] = tmp.get(0);
        return perm;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $942递增字符串匹配().diStringMatch("DDI")));
    }
}
