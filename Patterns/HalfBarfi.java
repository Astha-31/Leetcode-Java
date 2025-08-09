import java.util.*;
public class HalfBarfi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < 2* n - 1; i++){
            int stars= i >= n  ? 2* n - i - 1: i + 1 ;
            for(int j = 0; j <stars; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
