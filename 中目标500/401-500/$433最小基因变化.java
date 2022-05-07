import java.util.*;
import java.util.stream.Collectors;

/**
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 *
 */

public class $433最小基因变化 {

    boolean[] cache;
    int min = -1;
    int len;
    public int minMutation(String start, String end, String[] bank) {
        if (notContains(bank, end)) {
            return -1;
        }
        len = bank.length;
        cache = new boolean[len];
        for (int i = 0; i < len; ++i) {
            if (Objects.equals(bank[i], start)) {
                cache[i] = true;
            }
        }
        dfs(start, end, bank, 0);
        return min;
    }
    void dfs(String str, String end, String[] bank, int num) {
        if (Objects.equals(str, end)) {
            if (min == -1) {
                min = num;
            } else {
                min = Math.min(num, min);
            }
            return;
        }
        for (int i = 0; i < len; ++i) {
            if (!cache[i] && oneLetter(bank[i], str)) {
                cache[i] = true;
                dfs(bank[i], end, bank, num+1);
                cache[i] = false;
            }
        }
    }

    // 是否只有一个字符不同
    boolean oneLetter(String s1, String s2) {
        int num = 0;
        for (int i = 0; i < 8; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                num++;
            }
        }
        return num == 1;
    }
    // bank中不包含end
    boolean notContains(String[] bank, String end) {
        if (bank == null || bank.length == 0) {
            return true;
        }
        int i = bank.length - 1;
        while (i >= 0 && !Objects.equals(bank[i], end)) {
            i--;
        }
        return i == -1;
    }

    // 广度优先遍历BFS
    public int minMutation2(String start, String end, String[] bank) {
        Set<String> cnt = new HashSet<>();
        Set<String> visited = new HashSet<>();
        char[] keys = {'A', 'C', 'G', 'T'};
        cnt.addAll(Arrays.asList(bank));
        if (start.equals(end)) {
            return 0;
        }
        if (!cnt.contains(end)) {
            return -1;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);
        int step = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (keys[k] != curr.charAt(j)) {
                            StringBuffer sb = new StringBuffer(curr);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            if (!visited.contains(next) && cnt.contains(next)) {
                                if (next.equals(end)) {
                                    return step;
                                }
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new $433最小基因变化().minMutation("AAAAACCC","AACCCCCC",
                new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"}));
    }
}
