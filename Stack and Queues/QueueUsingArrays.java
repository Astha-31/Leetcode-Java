import java.util.*;
public class QueueUsingArrays {
    private int size;
    private int arr[];
    private int front;
    private int end;
    int currentsize;

    public  QueueUsingArrays(int size) {
        this.size = size;
        this.arr = new int[size];
        this.front = -1;
        this.end = -1;
        this.currentsize = 0;
    }

    public void add(int element){
        if(currentsize == size){
            return;
        }
        
        if(currentsize == 0){
            front++;
            
        }
        end = (end + 1) % size;
        arr[end] = element;
        currentsize++;
        
    }

    public int poll(){
        if(front == -1){
            return -1;
        }
        int x = arr[front];
        front =(front + 1) % size;
        currentsize--;
        if(currentsize == 0){
            end = -1;
            front = -1;
        }
        return x;
    }

    public int peek(){
        if(front == -1){
            return -1;
        }
        return arr[front];
    }
    public int getSize(){
        return currentsize;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        QueueUsingArrays q = new QueueUsingArrays(n);
        sc.close();
        q.add(5);
        q.add(7);
        q.add(8);
        q.add(4);
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.getSize());
    }

}
