import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入: head = [0,1,2,3,4], nums = [0,3,1,4]    输出: 2
 * 解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 *
 * 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。
 */
public class $817链表组件 {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for (int num : nums) {
            numsSet.add(num);
        }
        boolean inSet = false;
        int res = 0;
        while (head != null) {
            if (numsSet.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    res++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0,
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4)))));
        System.out.println(new $817链表组件().numComponents(root, new int[]{0,3,1,4}));
    }
}
