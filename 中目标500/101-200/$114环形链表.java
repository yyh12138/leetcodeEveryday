/**
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class $114环形链表 {

    // 利用 Set<ListNode> 存node对象
    public boolean hasCycle(ListNode head) {
        ListNode t = head;
        while (t!=null) {
            if (t.val!=Integer.MIN_VALUE) {
                t.val = Integer.MIN_VALUE;
                t = t.next;
            }else {
                return true;
            }
        }
        return false;
    }
    // 快慢指针
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode first = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode last = new ListNode(-4);
        first.next = second;
        second.next = third;
        third.next = last;
        last.next = second;
        System.out.println(new $114环形链表().hasCycle(first));
    }
}
