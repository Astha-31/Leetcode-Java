public class Arrayreverse {

    private static void swap(int arr[], int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    private static void reverse(int l,int arr[], int r){
        if(l >= r) return;
        swap(arr, l, r);
        reverse( l+ 1, arr, r-1);
    }
    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 5, 6};
        reverse(0, arr, arr.length - 1);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
