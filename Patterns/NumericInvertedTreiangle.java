import java.util.*;
public class NumericInvertedTreiangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = n; i >= 0; i--){
            for(int j = 0; j < i; j++){
                System.out.print( j + 1 + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
