public class oneton {

    private static void print(int i, int n){
        if(i > 10) return;

        System.out.println(i);
        print(i + 1, n);
    }
    public static void main(String[] args){
        int m= 10;
        print(1, m);
    }
}
