import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入：s = "[123,[456,[789]]]",
 * 输出：[123,[456,[789]]]
 * 解释：返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
 * 1. 一个 integer 包含值 123
 * 2. 一个包含两个元素的嵌套列表：
 *     i.  一个 integer 包含值 456
 *     ii. 一个包含一个元素的嵌套列表
 *          a. 一个 integer 包含值 789
 */
abstract class NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    abstract public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    abstract public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    abstract public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    abstract public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    abstract public List<NestedInteger> getList();
}
// 举例，并无实际作用
class EntityInteger extends NestedInteger {
    public EntityInteger() { }
    public EntityInteger(int val) { }
    @Override
    public boolean isInteger() { return false; }
    @Override
    public Integer getInteger() { return null; }
    @Override
    public void setInteger(int value) { }
    @Override
    public void add(NestedInteger ni) { }
    @Override
    public List<NestedInteger> getList() { return null; }
}

public class $385语法分析器 {
    int start=0;
    public NestedInteger deserialize(String s) {
        //此函数表示的是从start开始解析
        if(s.charAt(start)=='['){
            //表明之后的一段是个NestedInteger列表：
            start++;//跳到真正的元素的第一个字符
            NestedInteger nestedInteger = new EntityInteger();//主函数的总nested
            while(s.charAt(start)!=']'){
                //终止条件是，在本层遇到一个“]”，表示的是本层的嵌套解析结束
                nestedInteger.add(deserialize(s));//从此时的start开始解析
                if(s.charAt(start)==','){start++;}//遇到逗号说明后边还有同组的nested
            }
            start++;//由于此时start指向的位置是“]”，需要右移
            return nestedInteger;
        }
        else{
            //本层是单个数字
            int positive=1;
            if(s.charAt(start)=='-') {
                positive=-1;
                start++;
            }
            int num=0;
            while(start<s.length()) {
                char c=s.charAt(start);
                if(Character.isDigit(c)){
                    num=10*num+c-'0';
                    start++;
                }
                //注意数字解析结束后，肯定会遇到“,”或者“]”，因此承接了if的那个分支，因而不用start++来跳过
                else {
                    break;
                }//既然是纯数字，那么就遇到非数字的字符就可以溜了
            }
            return new EntityInteger(positive*num);
        }
    }

    public static void main(String[] args) {
        String s = "[123,[456,[789]]]";
        Stack<Character> stack = new Stack<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if (s.charAt(i)==']') {
                String num = "";
                stack.pop();
                while (!stack.empty()) {
                    if(stack.peek()!='[') {
                        num = stack.pop() + num;
                    }else {
                        stack.pop();
                        break;
                    }
                }
                res.add(num);
            }
        }
        System.out.println(res);
    }
}
