import java.util.*;
import java.util.stream.Collectors;

/**
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 *
 */

public class $433最小基因变化 {

    List<Integer> times = new ArrayList<>();
    public int minMutation(String start, String end, String[] bank) {
        List<String> list = new ArrayList<>(Arrays.asList(bank));
        if(!list.contains(end)) {
            return -1;
        }
        if (list.size()==1) {
            return 1;
        }
        dfs(start, end, list, bank.length);
        List<Integer> collect = times.stream().sorted().collect(Collectors.toList());
        return collect.get(0);
    }

    private void dfs(String now, String end, List<String> bank, int size) {
        if (now.equals(end)) {
            if (size-bank.size()<=size) {
                times.add(size-bank.size());
            }
        }else {
            for (int i = 0; i < bank.size(); i++) {
                String s = bank.get(i);
                if (isNextGenetic(now, s)) {
                    bank.remove(s);
                    dfs(s, end, bank, size);
                    bank.add(s);
                }
            }
        }
    }

    private boolean isNextGenetic(String now, String next) {
        int flag = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i)!=next.charAt(i)) {
                flag++;
            }
        }
        return flag == 1;
    }

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
