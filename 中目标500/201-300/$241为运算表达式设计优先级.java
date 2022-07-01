import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 按不同优先级组合数字和运算符，计算并返回所有可能组合的结果
 *
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 */
public class $241为运算表达式设计优先级 {
    // expression = "2*3-4*5"
    // (2*(3-(4*5))) = -34
    // ((2*3)-(4*5)) = -14
    // ((2*(3-4))*5) = -10
    // (2*((3-4)*5)) = -10
    // (((2*3)-4)*5) = 10
    // 分治法，碰到运算符号，递归求解前一半的值和后一半的值，然后根据运算符号，计算两者构成的值。
    // 记录已经计算出来的字符串对应的值，避免重复计算。
    public Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> list = new ArrayList<>();
        int len = input.length();
        for(int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {  // 出现运算符号，递归求解前半段和后半段。
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));

                for(int l : left) {
                    for(int r : right) {
                        switch(c) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if(list.size() == 0) {
            list.add(Integer.valueOf(input));
        }
        // 单独一个数字的情况 (可能出现多位数)
        map.put(input, list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new $241为运算表达式设计优先级().diffWaysToCompute("2*3-4*5"));
    }
}
