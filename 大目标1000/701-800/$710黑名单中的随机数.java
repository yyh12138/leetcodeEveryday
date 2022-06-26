import java.util.*;

/**
 * 输入
 * ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
 * [[7, [2, 3, 5]], [], [], [], [], [], [], []]
 * 输出
 * [null, 0, 4, 1, 6, 1, 0, 4]
 * 解释
 * Solution solution = new Solution(7, [2, 3, 5]);
 * solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
 *                  // 0、1、4和6的返回概率必须相等(即概率为1/4)。
 * solution.pick(); // 返回 4
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 6
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 0
 * solution.pick(); // 返回 4
 */
public class $710黑名单中的随机数 {
    public static void main(String[] args) {
        BlackList blackList = new BlackList(7, new int[]{2,3,5});
        System.out.println(blackList.pick());
        System.out.println(blackList.pick());
        System.out.println(blackList.pick());
        System.out.println(blackList.pick());
        System.out.println(blackList.pick());
        System.out.println(blackList.pick());
        System.out.println(blackList.pick());
    }
}

class BlackList {
    Map<Integer, Integer> b2w;
    Random random;
    int bound;
    // 寻找黑名单与白名单的映射关系
    public BlackList(int n, int[] blacklist) {
        b2w = new HashMap<>();
        random = new Random();
        int m = blacklist.length;
        bound = n - m;
        Set<Integer> black = new HashSet<>();
        for (int b : blacklist) {
            if (b >= bound) {
                black.add(b);
            }
        }

        int w = bound;
        for (int b : blacklist) {
            if (b < bound) {
                while (black.contains(w)) {
                    ++w;
                }
                b2w.put(b, w);
                ++w;
            }
        }
    }
    public int pick() {
        int x = random.nextInt(bound);
        return b2w.getOrDefault(x, x);
    }
}