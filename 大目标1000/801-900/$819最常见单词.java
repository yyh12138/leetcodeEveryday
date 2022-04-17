import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 */
public class $819最常见单词 {

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph=paragraph.toLowerCase();
        paragraph=paragraph.replace('!',' ').replace('?',' ').replace('\'',' ').replace(',',' ').replace(';',' ').replace('.',' ').trim();
        String[] s = paragraph.split(" ");
        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();
        //被禁用的单词放入map1
        for(String str:banned){
            map1.put(str,1);
        }
        //把没有禁用的单词放入map2
        for(String str : s){
            if(!map1.containsKey(str)&&!str.equals("")){
                map2.put(str,map2.getOrDefault(str,0)+1);
            }
        }
        //在map2找出出现最多的单词
        int max=-1;
        String res=null;
        for(String str:map2.keySet()){
            if(map2.get(str)>max){
                max=map2.get(str);
                res=str;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] banned = {"bob", "hit"};
        System.out.println(new $819最常见单词().mostCommonWord("Bob. hIt, baLl", banned));
    }
}
