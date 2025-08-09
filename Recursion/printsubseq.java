import java.util.*;
public class printsubseq {

    private static void print(int index, int[] arr, int n, int sum, int k, List<Integer> current){
        if(index >= n){
            if(sum == k){
                for(int i = 0; i < current.size(); i++){
                    System.out.print(current.get(i) + " ");
                }
                System.out.println();
            }
            return;
        }

        current.add(arr[index]);
        sum += arr[index];
        print(index +1, arr, n, sum, k , current);
        sum -= arr[index];
        current.remove(current.size() - 1);
        print(index +1 , arr, n, sum, k, current);

    }
    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 5 ,6};
        int sum = 0;
        int n = arr.length;
        List<Integer> current = new ArrayList<>();
        print(0, arr, n, sum, 5, current);
    }
}
