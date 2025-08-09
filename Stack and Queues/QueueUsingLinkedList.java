import java.util.*;
class ListNode{
    ListNode next;
    int val;
    public ListNode(int val){
        this.next = null;
        this.val = val;
    }
}
public class QueueUsingLinkedList {
    ListNode start;
    ListNode end;
    int size;
    public QueueUsingLinkedList(){
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    public void push(int x){
        ListNode n = new ListNode(x);
        if(start == null){
            start = n;
            end = n;
        }
        end.next = n;
        end = end.next;
        size++;
    }

    public void pop(){
        if(start == null){
            return;
        }
        start = start.next;
        size--;
    }

    public int peek(){
        if(start == null){
            System.out.println("Queue is empty");
            return -1;
        }
        return start.val;
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        sc.close();
        System.out.println("the first el is :" + q.peek());
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(8);
        q.push(0);

        System.out.println("the first el is :" + q.peek());
        q.pop();
        System.out.println(q.peek());
        System.out.println(q.getSize());
    }

}
