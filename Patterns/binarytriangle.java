import java.util.*;
public class binarytriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 1;
        for(int i = 0; i < n; i++){
            if(i%2==0)start = 1;
            else start = 0; 
            for(int j = 0; j < i+ 1; j++){
               System.out.print(start + " ");
               start = 1 - start;
            }
            System.out.println();   
        }
        sc.close();
    }
}
