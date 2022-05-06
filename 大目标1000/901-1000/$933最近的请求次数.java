import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入：
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * 输出：
 * [null, 1, 2, 3, 3]
 * 解释：
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
 * recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
 * recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
 */
public class $933最近的请求次数 {
    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping2(1));
        System.out.println(obj.ping2(100));
        System.out.println(obj.ping2(3001));
        System.out.println(obj.ping2(3002));

    }
}
class RecentCounter {
    List<Integer> list;
    Queue<Integer> q;
    public RecentCounter() {
        list = new ArrayList<>();
        q = new LinkedList<>();
    }

    public int ping(int t) {
        list.add(t);
        int tmp = 0;
        for (Integer integer : list) {
            if (integer>=t-3000 && integer<=t) {
                tmp++;
            }
        }
        return tmp;
    }
    public int ping2(int t) {
        while (!q.isEmpty()) {
            int time = q.peek();
            if (time < t - 3000) {
                q.poll();
            } else {
                break;
            }
        }
        q.add(t);
        return q.size();
    }
}
