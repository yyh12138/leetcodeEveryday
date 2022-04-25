/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * 不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */

public class $25k个一组翻转链表 {

    /**
     * 1->2->3->4->5
     * 2->1->4->3->5
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode first = head;
        ListNode last = head;
        int split = 1;
        if (k==0) {
            return head;
        }
        while (last!=null) {
           if (k>split) {
               last = last.next;
               split++;
           }
           if (k==split) {
               reverseK(first, last, k);
               first = last.next;
               last = first;
               split = 1;
           }
        }
        return head;
    }
    // k个结点翻转
    private void reverseK(ListNode first, ListNode last, int k) {

    }

    /**
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     *     void print() {}
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        new $25k个一组翻转链表().reverseKGroup(head, 2).print();
    }
}
