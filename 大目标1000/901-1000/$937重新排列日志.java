import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * 输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * 解释：
 * 字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
 * 数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
 */

public class $937重新排列日志 {

    public String[] reorderLogFiles(String[] logs) {
        List<String> digList = new ArrayList<>();
        List<String> wordList = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            String[] ss = logs[i].split(" ");
            if (ss[1].matches("^[a-z]+")) {
                wordList.add(logs[i]);
            }else {
                digList.add(logs[i]);
            }
        }
        List<String> collect = wordList.stream().sorted(
                (i, j) -> {
                    int iIndex = i.indexOf(" ");
                    int jIndex = j.indexOf(" ");
                    int n = i.substring(iIndex).compareTo(j.substring(jIndex));
                    if (n == 0) {
                        return i.substring(0, iIndex).compareTo(j.substring(0, jIndex));
                    }else {
                        return n;
                    }
                }
        ).collect(Collectors.toList());
        collect.addAll(digList);
        return collect.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $937重新排列日志().reorderLogFiles(new String[]{
                "a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"
        })));// ["a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
    }
}
