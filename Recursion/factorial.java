public class factorial {
    private static int f(int n){
        if(n == 0 || n == 1) return 1;
        return n * f( n- 1);
    }
    public static void main(String[] args){
        int n = 0;
        System.out.println(f(n));
    }
}
