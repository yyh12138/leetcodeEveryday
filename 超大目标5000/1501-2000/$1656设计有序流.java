import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入
 * ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
 * [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
 * 输出
 * [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
 * 解释
 * OrderedStream os= new OrderedStream(5);
 * os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
 * os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
 * os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
 * os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
 * os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
 */
public class $1656设计有序流 {

    public static void main(String[] args) {
        OrderedStream stream = new OrderedStream(5);
        System.out.println(stream.insert(3, "ccccc"));
        System.out.println(stream.insert(1, "aaaaa"));
        System.out.println(stream.insert(2, "bbbbb"));
        System.out.println(stream.insert(5, "eeeee"));
        System.out.println(stream.insert(4, "ddddd"));
    }
}

/**
 * 实现 OrderedStream 类：
 *     OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 *     String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 *         如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个  id + 1 。
 *         否则，返回一个空列表。
 */
class OrderedStream {

    String[] list;
    int ptr = 1;

    public OrderedStream(int n) {
        list = new String[n+1];
    }

    public List<String> insert(int idKey, String value) {
        list[idKey] = value;
        List<String> res = new ArrayList<>();
        if (list[ptr] != null) {
            while (list[ptr] != null) {
                res.add(list[ptr]);
                ptr++;
                if (ptr>=list.length) {
                    break;
                }
            }
            return res;
        }else {
            return new ArrayList<>();
        }
    }
}
