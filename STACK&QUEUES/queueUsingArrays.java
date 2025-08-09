import java.util.*;
public class queueUsingArrays {
    private int start;
    private int end;
    private int size;
    private int[] arr;
    int cursize ;
    public queueUsingArrays(int size){
        this.start = 0;
        this.end = -1;
        this.size = size;
        this.arr = new int[size];
        this.cursize = 0;
    }
    public void push(int x){
        if(cursize ==size){
            System.out.println("Queue is full");
            return;
        }
        end = (end + 1)% size;
        arr[end] = x;
        cursize++;
    }
    public void pop(){
        if(cursize != 0){
            start = (start +1) % size;
            cursize--;
        }else{
            System.out.println("stack is empty");
        }
    }
    public int peek(){
        if(cursize == 0){
            return -1;
        }
        return arr[start];
    }

    public int size(){
        return cursize;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        queueUsingArrays q = new queueUsingArrays(n);

        q.push(8);
        q.push(7);
        q.pop();
        q.push(10);
        System.out.println(q.peek());
        System.out.println(q.size());
        sc.close();
    }


}
