import java.util.*;
public class StackUsingArray{
    private int top;
    private int[] arr;
    private int size;

    
    public StackUsingArray(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }
    public void push(int element){
        if(top >= size - 1){
            System.out.println("stack overflow");
        }
        top += 1;
        arr[top] = element;
    }

    public  void pop(){
        if(top == -1){
           System.out.println("stack underflow");
           return;
        }
        top = top -1;
    }

    public int  peek (){
        if(top == -1){
            return -1;
        }
        return arr[top];
    }

    public int getsize (){
        if(top == -1){
            return 0;
        }
        return top + 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        StackUsingArray st = new StackUsingArray(n);
        st.push( 5);
        st.push(6);
        st.push(8);
        System.out.println("the top ele is :" + st.peek());
        st.pop();
        System.out.println(st.getsize());
        sc.close();
    }
}