import java.util.*;
public class print1sub {

    private static boolean print(int index, int[] arr, int n, int sum, List<Integer> current, int k){
        if(index >= n){
            if(sum == k){
                for(int i = 0; i < current.size();i++){
                    System.out.print(current.get(i) + " ");
                }
                System.out.println();
                return true;
            } 
            else{
                return false;
            }  
        }
        current. add(arr[index]);
        sum += arr[index];
        if(print(index + 1, arr, n, sum, current, k) == true)return true;
        sum -= arr[index];
        current.remove(current.size() - 1);
        if(print(index + 1, arr, n, sum, current, k) == true) return true;
        return false;
        
    }
    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 5, 6};
        int sum = 0;
        int n = arr.length;
        List<Integer> current = new ArrayList<>();
        print(0, arr, n, sum , current, 4);
    }
}
