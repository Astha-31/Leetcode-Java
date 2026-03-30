import java.util.*;
public class spacereplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The string is ");
        String s = sc.nextLine();
        String replaced = s.replace(" ", "%20");
        System.out.println(replaced);
        sc.close();

    }
}
