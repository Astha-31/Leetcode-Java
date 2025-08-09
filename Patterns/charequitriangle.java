import java.util.*;
public class charequitriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            int bp = (2* i+ 1)/2;
            for(int j = 0; j < n - i - 1; j++){
                System.out.print(" ");
            }

            char c = 'A';
            for(int j = 0; j < 2* i + 1; j++){
                System.out.print(c);
                if(j < bp)c++;
                else c--;
            }

            for(int j = 0; j < n - i - 1; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
        sc.close();
        
    }
}
