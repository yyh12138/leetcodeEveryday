import java.util.HashMap;
import java.util.Map;

/**
 * 输入：url = "https://leetcode.com/problems/design-tinyurl"
 * 输出："https://leetcode.com/problems/design-tinyurl"
 * 解释：
 * Solution obj = new Solution();
 * string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
 * string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
 */
public class $535TinyURL加密与解密 {
    static class Codec {
        Map<String, String> map = new HashMap<>();
        static final String INDEX = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        static final String TINYURL_PREFIX = "http://tinyurl.com/";
        public Codec() {}
        public String encode(String longUrl) {
            char[] chs = new char[6];
            while(true){
                for(int i = 0; i < 6; i++){
                    chs[i] = INDEX.charAt((int)(Math.random()*62));
                }
                String shortUrl = TINYURL_PREFIX + new String(chs);
                if(!map.containsKey(shortUrl)){
                    map.put(shortUrl, longUrl);
                    return shortUrl;
                }
            }
        }
        public String decode(String shortUrl) {
            return map.get(shortUrl);
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String encode = codec.encode("");
        System.out.println(encode);
        System.out.println(codec.decode(encode));
    }

}

