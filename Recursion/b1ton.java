public class b1ton {

    private static void print(int i, int n){
        if(i <= 0) return;

        print(i - 1, n);
        System.out.println(i);
    }
    public static void main(String[] args){
        int n = 10;
        print(n, n);
    }
}
