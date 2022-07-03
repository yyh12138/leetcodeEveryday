import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 */
public class $1200最小绝对差 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            int a = arr[i];
            int b = arr[i+1];
            if (b-a < min) {
                min = b-a;
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int a = arr[i];
            int b = arr[i+1];
            if (b-a==min) {
                List<Integer> pair = Arrays.asList(a, b);
                res.add(pair);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $1200最小绝对差().minimumAbsDifference(new int[] {4,2,1,3}));
    }
}
