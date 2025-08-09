import java.util.*;
public class NumericTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //print 1 12 123 1234 ....
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i + 1; j++){
                System.out.print(j+ 1 + " ");
            }
            System.out.println();
        }

        //print 1 22 333 4444 ...
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+ 1; j++){
                System.out.print(i + 1 + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
