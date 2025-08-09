public class sumofnnaturalnumbers {
    private static void sum(int i, int n){
        if(n < 1){
            System.out.println(i);
            return;
        } 
        sum(i + n ,n- 1);
    }
    public static void main(String[] args){
        int n = 3;
        sum(0, n);
        
    }
}
