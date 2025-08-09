import java.util.*;

public class leftRotateByOnePlace {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Value of n is" + n);
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int tem = arr[0];
        for(int i = 1; i < n; i++){
            arr[i-1] = arr[i];
        }
        arr[n - 1] = tem;

        System.out.println("Array after left rotation by one place:");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
//T.C - 0(N);
//S.C - 0(1);
