import java.util.Arrays;

/**
 * arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * 我们最多能将数组分成多少块？
 *
 * 输入: arr = [5,4,3,2,1]  输出: 1
 * 将数组分成2块或者更多块，都无法得到所需的结果。例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。
 */
public class $768最多能完成排序的块二 {

    public int maxChunksToSorted(int[] arr) {
        int[] cln = arr.clone();
        Arrays.sort(cln);

        int pref = 0, chunks = 0;
        for (int i = 0; i < arr.length; ++i) {
            if ((pref += arr[i] - cln[i]) == 0) {
                ++chunks;
            }
        }
        return chunks;
    }

    public static void main(String[] args) {
        System.out.println(new $768最多能完成排序的块二().maxChunksToSorted(new int[] {5,4,3,2,1}));
    }
}
