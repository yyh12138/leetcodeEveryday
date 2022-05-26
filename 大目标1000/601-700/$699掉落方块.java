import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入: [[1, 2], [2, 3], [6, 1]]
 * 输出: [2, 5, 5]
 * 解释:
 * 第一个方块 positions[0] = [1, 2] 掉落：
 * _aa
 * _aa
 * -------
 * 方块最大高度为 2 。
 * 第二个方块 positions[1] = [2, 3] 掉落：
 * __aaa
 * __aaa
 * __aaa
 * _aa__
 * _aa__
 * --------------
 * 方块最大高度为5。
 * 大的方块保持在较小的方块的顶部，不论它的重心在哪里，因为方块的底部边缘有非常大的粘性。
 * 第三个方块 positions[1] = [6, 1] 掉落：
 * __aaa
 * __aaa
 * __aaa
 * _aa
 * _aa___a
 * --------------
 * 方块最大高度为5。
 * 因此，我们返回结果[2, 5, 5]。
 */
public class $699掉落方块 {

    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int max = 0;
        int n = positions.length;
        int[] height = new int[n];
        for(int i=0;i<n;++i){
            int l = positions[i][0];
            int h = positions[i][1];
            int r =l + h;
            height[i] = h;
            for(int j=0;j<i;++j){
                int ll = positions[j][0];
                int rr = positions[j][0] + positions[j][1];
                int hh = height[j];
                //judge if overlap
                if((ll<=l && l<rr) || (ll<r && r <=rr) || (l<=ll && r >=rr)) {
                    height[i] = Math.max(height[j] + h,height[i]);
                }
            }
            max = Math.max(max,height[i]);
            res.add(max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $699掉落方块().fallingSquares(new int[][]{
                {6,1}, {9,2}, {2,4}
        }));
    }
}
