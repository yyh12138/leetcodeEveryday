/**
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"],
 *      word1 = "a", word2 = "student"
 * 输出：1
 *
 */
public class $1711单词距离 {

    public int findClosest(String[] words, String word1, String word2) {
        int start = -10000;
        int end = 10000;
        int min = 10000;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                start = i;
            }
            if (words[i].equals(word2)) {
                end = i;
            }
            min = Math.min(min, Math.abs(end-start));
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new $1711单词距离().findClosest(new String[]{"I","am","a","student","from","a","university","in","a","city"}, "a", "student"));
    }
}
