public class MergeSort {

    private static void mergeSort(int[] nums, int i , int n){

        if(i >= n) return;
        int mid = (i +n)/2;
        mergeSort(nums, i, mid);
        mergeSort(nums, mid+ 1, n);
        merge(nums, i, mid, n);
    }

    private static void merge(int[] nums, int i, int mid, int n){
        int[] temp = new int[n - i + 1];
        int k = 0;
        int left = i;
        int right = mid + 1;
        while(left <= mid && right <= n ){
            if(nums[left] <= nums[right]){
                temp[k++] = nums[left];
                left++; 
            }
            else {
                temp[k++]= nums[right];
                right++;
            }
        }
        while(left <= mid){
            temp[k++] = nums[left];
            left++;
        }
        while(right <= n){
            temp[k++] = nums[right];
            right++;
        }
        for(int j = 0; j < temp.length; j++){
            nums[i + j] = temp[j];
        }
    }
    public static void main(String[] args) {
        int[] nums = {8, 11, 4, 7, 2, 6};
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        for(int i = 0; i < n; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
