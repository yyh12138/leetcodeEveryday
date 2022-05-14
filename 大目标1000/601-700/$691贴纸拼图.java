import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入： stickers = ["with","example","science"], target = "thehat"
 * 输出：3
 * 解释：
 * 我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
 * 把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
 * 此外，这是形成目标字符串所需的最小贴纸数量。
 */
public class $691贴纸拼图 {
    // 回溯 + 剪枝 + 记忆存储
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] stickerCnts = new int[n][26]; // 贴纸词频表
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerCnts[i][c - 'a']++;
            }
        }

        int[] targetCnt = new int[26]; // 目标字符串词频表
        for (char c : target.toCharArray()) {
            targetCnt[c - 'a']++;
        }

        HashMap<String, Integer> memo = new HashMap<>(); // 记忆化缓存
        return dfs(stickerCnts, target, targetCnt, memo);
    }

    // DFS记忆化搜索
    // 任意使用stickers中的贴纸，搞定target （target的词频记录在targetCnts中），最少需要多少张贴纸？
    private int dfs(int[][] stickers, String target, int[] targetCnts,
                           HashMap<String, Integer> memo) {
        if (target.isEmpty()) { return 0; }
        if (memo.containsKey(target)) { return memo.get(target); }

        int n = stickers.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) { // 枚举尝试使用每一种贴纸，做第一张
            int[] sticker = stickers[i];
            int[] nextCnts = new int[26];
            // 如果target中的字母在sticker中都不存在。尝试下一个
            if (!hasLetterInSticker(sticker, target)) {
                continue;
            }
            // 可以使用这种贴纸，取用1张，消去字符：
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                int cnt = Math.max(targetCnts[j] - sticker[j], 0); // 还剩cnt张相同的字母
                char letter = (char) ('a' + j);
                sb.append(String.valueOf(letter).repeat(Math.max(0, cnt))); // sb为原target还剩的字符构成的字符串
                nextCnts[j] = cnt; // nextCnts为sb的字符串词频表
            }
            // 继续DFS：
            int next = dfs(stickers, sb.toString(), nextCnts, memo);
            if (next != -1) { ans = Math.min(ans, 1 + next); }
        }
        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        memo.put(target, ans);
        return ans;
    }

    // 贴纸sticker中是否含有target中的字母？：
    // 如果target的所有字母都不在贴纸sticker中，返回false；
    // 反之，只要有任意一个字母（不妨设为target[0]）存在于贴纸sticker中，返回true；
    private boolean hasLetterInSticker(int[] sticker, String target) {
        return sticker[target.charAt(0) - 'a'] != 0; // 佛性剪枝
    }

    public static void main(String[] args) {
        System.out.println(new $691贴纸拼图().minStickers(new String[]{"with","example","science"},"thehat"));
    }
}
