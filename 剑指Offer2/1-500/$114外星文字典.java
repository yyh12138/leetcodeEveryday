import java.util.*;

/**
 * 输入：words = ["wrt","wrf","er","ett","rftt"]
 * 输出："wertf"
 */
public class $114外星文字典 {

    public String alienOrder(String[] words) {
        // graph[i][j]：i点（字符i+'a'） 是否存在指向 j点（字符j+'a'）的边，即：字符i+'a'排在字符j+'a'之前
        boolean[][] graph = new boolean[26][26];
        int[] inDegree = new int[26]; // 入度表 inDegree[i]：i点的入度值
        boolean[] exist = new boolean[26]; // exist[i]：在图中是否存在字符i+'a'

        // 将存在的字符加入exist，标记存在这个点：
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                exist[c-'a'] = true;
            }
        }

        // 两两遍历比较每个字符串，建图：
        for (int i = 0; i < words.length-1; i++) {
            int j = i+1;
            char[] word1 = words[i].toCharArray();
            char[] word2 = words[j].toCharArray();
            int cur = 0;
            while (cur < word1.length && cur < word2.length && word1[cur] == word2[cur]) {
                cur++;
            }
            if (cur < word1.length && cur == word2.length) {
                return "";
            }
            if (cur < word1.length && cur < word2.length) {
                char from = word1[cur], to = word2[cur];
                inDegree[to-'a'] += graph[from-'a'][to-'a'] ? 0 : 1;
                graph[from-'a'][to-'a'] = true;
            }
        }
        // 拓扑排序，根据图graph、入度表inDegree，生成拓扑排序结果
        return topoSort(graph, inDegree, exist);
    }

    // 拓扑排序
    private String topoSort(boolean[][] graph, int[] inDegree, boolean[] exist) {
        StringBuilder order = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (exist[i] && inDegree[i] == 0) {
                queue.add(i);
            }
            if (exist[i]) {
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            order.append((char)(i+'a'));
            for (int j = 0; j < 26; j++) {
                if (graph[i][j]) {
                    graph[i][j] = false;
                    if (--inDegree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }

        // 如果排序的点数等于图中总点数，则存在拓扑序，否则，不存在：
        return order.length() == count ? order.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(new $114外星文字典().alienOrder(new String[]{
                "wrt","wrf","er","ett","rftt", "rfttt"
        }));
    }
}
