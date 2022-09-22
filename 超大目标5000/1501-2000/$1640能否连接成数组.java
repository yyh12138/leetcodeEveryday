import java.util.HashMap;
import java.util.Map;

/**
 * arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
 * 以任意顺序连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true
 *
 * 输入：arr = [15,88], pieces = [[88],[15]]    输出：true
 * 解释：依次连接 [15] 和 [88]
 */
public class $1640能否连接成数组 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }

        for (int i = 0; i < arr.length;) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int[] array = map.get(arr[i]);
            for (int j = 0; j < array.length; j++, i++) {
                if (arr[i] != array[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new $1640能否连接成数组().canFormArray(new int[] {15,88}, new int[][]{{88}, {15}}));
    }
}
