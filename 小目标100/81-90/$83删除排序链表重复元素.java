/**
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class $83删除排序链表重复元素 {
/**
*   public class ListNode {
*     int val;
*     ListNode next;
*     ListNode() {}
*     ListNode(int val) { this.val = val; }
*     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
* }
*/

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val==cur.next.val){
                cur.next= cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return head;
    }

    private ListNode dfs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = dfs(head.next);
        if(head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(1, new ListNode(2)));
        new $83删除排序链表重复元素().deleteDuplicates(head).print();
    }
}
