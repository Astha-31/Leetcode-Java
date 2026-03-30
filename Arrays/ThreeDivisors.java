import java.util.*;
class ThreeDivisors {
    private static boolean isPrime(int n){
        if( n < 2) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The input is :");
        int n = sc.nextInt();
        // if ( n < 3) return false;
        // int c = 0;
        // for(int i = 1; i <= n; i++){
        //     if(n % i == 0) c++;
        // }
        // return c == 3;

        int sqrt = (int)Math.sqrt(n);
        if(sqrt * sqrt != n) System.out.println(false);
        else System.out.println(isPrime(sqrt)); 
        sc.close();
    }
}
