import java.util.*;
public class Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+ 1; j++){
                System.out.print(start + " ");
                start++;

            }
            System.out.println();
        }
        sc.close();
    }
}
