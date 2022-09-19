import java.util.*;

/**
 * 将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * 输入：nums = [1,1,2,2,2,3]    输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 */
public class $1636按频率将数组升序排序 {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer rate = map.getOrDefault(num, 0);
            map.put(num, ++rate);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o2.getKey() - o1.getKey();
                }else {
                    return o1.getValue() - o2.getValue();
                }
            }
        });
        int[] res = new int[nums.length];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            int key = entry.getKey();
            int rate = entry.getValue();
            for (int j = 1; j <= rate; j++) {
                res[i++] = key;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $1636按频率将数组升序排序().frequencySort(new int[]{1, 1, 2, 2, 2, 3, 1})));
    }
}
