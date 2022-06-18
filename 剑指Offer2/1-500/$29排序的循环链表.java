import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal,使这个列表仍然是循环升序的。
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 输入：head = [3,4,1], insertVal = 2
 * 输出：[3,4,1,2]
 * 解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。
 *
 */

public class $29排序的循环链表 {

    public Node insert(Node head, int insertVal) {
        Node cur = null;
        Node next = null;
        Node realHead = null;
        //空的
        if(head == null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        //找到真正的头节点
        cur = head;
        next = head.next;
        while(cur.val <= next.val){
            cur = cur.next;
            next = next.next;
            if(cur == head) {
                break;
            }
        }
        realHead = next;
        //找插入位置
        while(next.val < insertVal){
            cur = next;
            next = next.next;
            //相等了，就随便插
            if(next == realHead) {
                break;
            }
        }
        //连接
        cur.next = new Node(insertVal);
        cur = cur.next;
        cur.next = next;
        return head;
    }

    public static void main(String[] args) {
        Node last = new Node(1);
        Node head = new Node(3, new Node(4, last));
        last.next = head;
        System.out.println(new $29排序的循环链表().insert(head, 2));
    }
}
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};