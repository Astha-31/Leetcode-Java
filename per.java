import java.util.*;
public class per{
    public static void main(String[] args) {
        int[] a= {1,1,3,3,4};
        Arrays.sort(a);
        int op = 0;
        int n = a.length;
        for(int i = 0; i <n; i++){
            if(a[i] < i+1){
                op += (i+1 - a[i]);
                a[i] = i+1;
            }
            
        }
        System.out.println(op);
    }
}