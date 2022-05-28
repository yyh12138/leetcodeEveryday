import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */

public class $155最小栈 {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin()); // -3
        obj.pop();
        System.out.println(obj.top()); // 0
        System.out.println(obj.getMin()); // -2
    }
}

class MinStack {

    int index; // 最小值位置
    List<Integer> list;

    public MinStack() {
        index = -1;
        list = new ArrayList<>();
    }

    public void push(int val) {
        if (list.size()==0) {
            index = 0;
        }else {
            if (list.get(index)>val) {
                index = list.size();
            }
        }
        list.add(val);
    }

    public void pop() {
        list.remove(list.size()-1);
        if (index==list.size()) {
            // 找移去后的最小元素下标
            int min = Integer.MAX_VALUE;
            for (int i=0; i<list.size(); i++) {
                Integer tmp = list.get(i);
                if (tmp < min) {
                    min = tmp;
                    index = i;
                }
            }
        }
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        return list.get(index);
    }
}
