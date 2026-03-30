public class name5{

    private static void reverse(int i, int[] arr, int n){
        if(i >= n/ 2) return;
        int temp = arr[i];
        arr[i] = arr[n - i - 1];
        arr[n - i - 1] = temp;
        reverse(i +1, arr, n);

    }
    private static int fib(int n ){
        if(n == 0 || n == 1) return n;
        return fib(n- 1) + fib(n-2);
    }

    private static boolean palindrome(String s, int n, int i){
        if(i >= n/2) return true;
        if(s.charAt(i) != s.charAt(n - i - 1)) return false;
         return palindrome(s, n, i+ 1);
    }
    // private static void print12n(int i, int n){
    //     if(i > n) return;
    //     System.out.println(i);
    //     print12n(i + 1, n);
        
    // }

    private static void printn21(int i, int n){
        if(i < 1) return;  
        System.out.println(i);
        printn21(i-1, n);
    }
    private static void f(int i , int n){
        if(i > n) return;
        System.out.println("Astha");
        f(i + 1, n);
    }
    public static void main(String[] args) {
        f(1, 5);
        
        printn21(5, 5);

        int[] arr = {11, 12, 13, 14, 15};
        int n = arr.length;
        reverse(0, arr, n);
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }

        String s = "KANAK";
        int k = s.length();
        System.out.println(palindrome(s, k, 0));
        System.out.println(fib(3));
    }
}