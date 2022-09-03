import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：[[1,2], [2,3], [3,4]]   输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *
 * 当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 */
public class $646最长数对链 {

    // 贪心
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)-> a[1]-b[1]);
        int res = 1, tmp = pairs[0][1];
        for(int i = 1; i < pairs.length; i++){
            if(pairs[i][0] > tmp){
                res++;
                tmp = pairs[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $646最长数对链().findLongestChain(new int[][]{
                {-7,-1}, {0,10}, {2,3}, {3, 10}, {3,6}, {4,5}, {7,9}, {7,9}
        }));
    }
}
