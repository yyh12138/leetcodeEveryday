import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
public class $23合并k个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) {
            return null;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            while (list!=null) {
                nums.add(list.val);
                list = list.next;
            }
        }
        List<Integer> collect = nums.stream().sorted().collect(Collectors.toList());
        if (collect.size()==0) {
            return null;
        }
        ListNode res = new ListNode(collect.get(0));
        ListNode tmp = res;
        for (int i = 1; i<collect.size(); i++) {
            int val = collect.get(i);
            tmp.next = new ListNode(val);
            tmp = tmp.next;
        }
        return res;
    }

    // 分治
    public ListNode mergeKLists2(ListNode[] lists){
        if(lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }
        if(lists.length == 2){
            return mergeTwoLists(lists[0],lists[1]);
        }
        int mid = lists.length/2;
        ListNode[] l1 = new ListNode[mid];
        for(int i = 0; i < mid; i++){
            l1[i] = lists[i];
        }
        ListNode[] l2 = new ListNode[lists.length-mid];
        for(int i = mid,j=0; i < lists.length; i++,j++){
            l2[j] = lists[i];
        }
        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode l3 = new ListNode(2, new ListNode(6, null));
        new $23合并k个升序链表().mergeKLists(new ListNode[]{}).print();
    }
}
