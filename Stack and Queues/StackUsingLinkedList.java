import java.util.*;
class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class StackUsingLinkedList {
     private ListNode top ;
     private int size;
     public StackUsingLinkedList(){
        this.top = null;
        this.size = 0;
     }
        public void push(int x){
            ListNode temp = new ListNode(x);
            temp.next = top;
            top = temp;
            size++;
        }

        public void pop(){
            if(top == null){
                return;
            }
            top = top.next;
            size--;
        }

        public int peek(){
            return top.val;
        }

        public int getSize(){
            return size;
        }
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            
            StackUsingLinkedList st = new StackUsingLinkedList();
            st.push(7);
            st.push(8);
            st.push(9);
            st.pop();
            System.out.println(st.peek());
            System.out.println(st.getSize());
            sc.close();

        }

     }

