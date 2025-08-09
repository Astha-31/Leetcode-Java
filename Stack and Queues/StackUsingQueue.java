import java.util.*;
public class StackUsingQueue {
    private Queue<Integer> q;
    private int size;

    public StackUsingQueue(){
        this.q = new LinkedList<>();
        this.size = 0;
    }

    public void push(int x){
        q.add(x);
        int n = q.size() - 1;
        for(int i = 0; i < n; i++){
            q.add(q.poll());
        }
        size++;
    }

    public void pop(){
        if(q.isEmpty()){
            System.out.println("the stack is empty");
            return;
        }
        q.poll();
        size--;
    }

    public int peek(){
        if(q.isEmpty()){
            System.out.println("the stack is empty");
            return -1;
        }
        return q.peek();
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StackUsingQueue st = new StackUsingQueue();
        sc.close();
        st.push(8);
        st.push(7);
        st.push(4);
        st.push(3);
        st.pop();
        System.out.println(st.peek());

        
    }
}
