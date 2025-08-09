import java.util.*;
class QueueUsingStack{

    private Stack<Integer> st1;
    private Stack<Integer> st2;
    private int size;
    public QueueUsingStack(){
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
        this.size = 0;
    }

    public void push(int x){
        st1.push(x);
        size++;
    }

    public void pop(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.add(st1.pop());
            } 
        }
        st2.pop();
        size--;
    }

    public int top(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.add(st1.pop());
            }

        }
        return st2.peek();
    }

    public int getSize(){
        return size;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        QueueUsingStack s = new QueueUsingStack();
        s.push(6);
        s.push(9);
        s.push(2);
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        System.out.println(s.getSize());
        sc.close();

    }
}