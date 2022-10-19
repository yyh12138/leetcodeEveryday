import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 输入：students = [1,1,0,0], sandwiches = [0,1,0,1]    输出：0
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,0,0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,0,1,1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [0,1,1]，三明治栈为 sandwiches = [1,0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,1,0]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1,0]，三明治栈为 sandwiches = [0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1]，三明治栈为 sandwiches = [1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = []，三明治栈为 sandwiches = []。
 * 所以所有学生都有三明治吃。
 *
 * 自助午餐提供圆形和方形的三明治，分别用数字 0 和 1 表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个 栈 里，每一轮：
 *     如果队列最前面的学生 喜欢 栈顶的三明治，那么会 拿走它 并离开队列。
 *     否则，这名学生会 放弃这个三明治 并回到队列的尾部。
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 * 给你两个整数数组students和sandwiches,其中sandwiches[i]是栈里面第i个三明治的类型（i=0是栈的顶部），students[j]是初始队列里第j名学生对三明治的喜好（j=0是队列的最开始位置）。
 * 返回无法吃午餐的学生数量。
 */
public class $1700无法吃午餐的学生数量 {

    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnt = new int[2];
        for (int student : students) {
            cnt[student]++;
        }
        for (int sandwich : sandwiches) {
            if (cnt[sandwich] > 0) {
                cnt[sandwich]--;
            } else {
                break;
            }
        }
        return cnt[0] + cnt[1];
    }

    public static void main(String[] args) {
        System.out.println(new $1700无法吃午餐的学生数量().countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
    }
}
