import java.util.*;
public class Character {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(char c = 'A'; c <= 'A' + i; c++){
                System.out.print(c);
            }
            System.out.println();
        }
        sc.close();
    }
}
