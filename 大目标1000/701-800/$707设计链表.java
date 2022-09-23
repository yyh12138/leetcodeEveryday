/**
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
public class $707设计链表 {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3,0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        System.out.println(linkedList.get(4));
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5,0);
        linkedList.addAtHead(6);
    }
}

class MyLinkedList {
    class Node {
        private int val;
        private Node next;
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
        public int getVal() {
            return val;
        }
        public void setVal(int val) {
            this.val = val;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
    Node first, last;
    public MyLinkedList() {
        Node total = new Node(0);
        first = total;
        last = total;
    }

    public int get(int index) {
        Node t = first.next;
        for (int i = 0; i < index; i++) {
            if (t==null) {
                return -1;
            }else {
                t = t.next;
            }
        }
        return t==null?-1:t.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val, first.next);
        first.next = node;
        first.val++;
        if (first==last) {
            last = node;
        }
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        last.next = node;
        last = node;
        first.val++;
    }

    public void addAtIndex(int index, int val) {
        if (index<=0) {
            addAtHead(val);
            return;
        }
        if(index==first.val) {
            addAtTail(val);
            return;
        }
        if (index>first.val) {
            return ;
        }
        if(index>0 && index<first.val) {
            Node t = first;
            for (int i = 0; i < index; i++) {
                t = t.next;
            }
            Node node = new Node(val, t.next);
            t.next = node;
            first.val++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index>=first.val || index<0) {
            return;
        }
        Node t = first.next;
        Node pre = first;
        for (int i = 0; i < index; i++) {
            pre = t;
            t = t.next;
        }
        pre.next = t.next;
        if (last==t) {
            last = pre;
        }
        first.val--;
    }
}

