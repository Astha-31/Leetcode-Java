import java.util.*;

public class leftRotateByDPlaces {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("The value of n is ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int k = 3;
        int start = 0, end = k - 1;
        while(start < end){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }

        int i = k;
        int j = n - 1;
        while(i < j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        start = 0;
        end = n -1;
        while(start < end){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }

        for(int b = 0; b < n; b++){
            System.out.println(a[b]);
        }
    }
}

//Time Complexity = 0(2N);
//Space Complexity = 0(1);