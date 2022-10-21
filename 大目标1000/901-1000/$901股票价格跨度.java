import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * 输出：[null,1,1,1,2,1,4,6]
 * 解释：
 * 首先，初始化 S = StockSpanner()，然后：
 * S.next(100) 被调用并返回 1，
 * S.next(80) 被调用并返回 1，
 * S.next(60) 被调用并返回 1，
 * S.next(70) 被调用并返回 2，
 * S.next(60) 被调用并返回 1，
 * S.next(75) 被调用并返回 4，
 * S.next(85) 被调用并返回 6。
 * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
 * (包括今天的价格 75) 小于或等于今天的价格。
 */
public class $901股票价格跨度 {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}

class StockSpanner {
    List<Integer> list;
    int i;
    public StockSpanner() {
        list = new ArrayList<>();
        this.i = 0;
    }
    public int next(int price) {
        int res = 0;
        list.add(price);
        for (int t=i; t>=0; t--) {
            if (list.get(t)<=price) {
                res++;
            }else {
                break;
            }
        }
        i++;
        return res;
    }
}
// 单调栈
class StockSpanner2 {
    Deque<int[]> stack; // [股票价格下标, 股票价格]
    int idx;

    public StockSpanner2() {
        stack = new ArrayDeque<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price) {
        idx++;
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int ret = idx - stack.peek()[0];
        stack.push(new int[]{idx, price});
        return ret;
    }
}