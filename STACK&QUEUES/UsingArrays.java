import java.util.*;

public class UsingArrays{
    private int top;
    private int size;
    private int[] arr = new int[size];
    public UsingArrays(int size){
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }
    public void push(int x){
        if(top < 5){
            top = top + 1;
            arr[top] = x;
        }
    }

    public void pop(){
        top = top -1;
    }

    public int peek(){
        return arr[top];
    }

    public int size(){
        return top + 1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        UsingArrays st = new UsingArrays(n);
        st.push( 5);
        st.push(6);
        st.push(8);
        System.out.println("the top ele is :" + st.peek());
        st.pop();
        System.out.println(st.size());
        sc.close();
    }

}

