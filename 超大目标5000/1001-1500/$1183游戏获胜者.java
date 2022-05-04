import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class $1183游戏获胜者 {

    public int findTheWinner(int n, int k) {
        CircleArray queue = new CircleArray(n);
        for (int i = 1; i <= n; i++) {
            queue.addQueue(i);
        }
        queue.printQueue();
        for (int i = 1; i < n; i++) {
            queue.pick(k);
            queue.printQueue();
        }
        return queue.get(0);
    }
    // 队列模拟
    public int findTheWinner2(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i ++ ) {
            q.add(i);
        }
        for (int i = 1; i < n; i ++ ) {
            for (int j = 1; j < k; j ++ ) {
                q.add(q.poll());
            }
            q.poll();
        }
        return q.poll();
    }

    public static void main(String[] args) {
        System.out.println(new $1183游戏获胜者().findTheWinner(6, 1));
    }
}

class CircleArray {
    private final int maxSize;
    private ListNode rear;
    private ListNode front;
    private ListNode now;

    //创建队列，构造函数就可以了
    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        front = new ListNode(0);
        rear = front;
        now = front;
    }

    public boolean empty() {
        if (rear == front) {
            return true;
        } else {
            return false;
        }
    }

    public void addQueue(int n) {
        //先判断队列是否满
        if (front.val==maxSize) {
            System.out.print("队列已满");
        } else {
            rear.next = new ListNode(n, front.next);
            rear = rear.next;
            front.val++;
        }
    }

    public void printQueue() {
        ListNode t = front.next;
        do {
            System.out.print(t.val+"->");
            t = t.next;
        }while (t!=front.next);
        System.out.println("\nnow: "+front.val);
    }

    public void pick(int k) {
        if (now==front) {
            now = front.next;
        }
        ListNode t = now;
        if (k==1) {
            front.next = t.next;
            now = t.next;
        }else {
            for (int i = 1; i < k-1; i++) {
                t = t.next;
            }
            ListNode t2 = t.next;
            if (t2==front.next) {
                front.next = t2.next;
            }
            t.next = t2.next;
            now = t2.next;
        }
        front.val--;
    }

    public int get(int i) {
        if (i==0) {
            return front.next.val;
        }
        return -1;
    }
}