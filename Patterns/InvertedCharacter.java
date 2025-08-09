import java.util.*;
public class InvertedCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = n - 1; i >= 0; i--){
            for(char c = 'A'; c <= 'A' + i; c++){
                System.out.print(c);
            }
            System.out.println();
        }
        sc.close();
    }
}
