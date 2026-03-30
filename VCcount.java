import java.util.*;
class VCcount{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("The String is: ");
        String s = sc.nextLine();
        int n = s.length();
        int vowel = 0; 
        int consonant = 0;
        for(int i = 0; i < n ; i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z' || ch>= 'A' && ch <= 'Z'){
                if("aeiou".indexOf(ch) != -1) vowel++;
                else consonant++;
            }
        }
        System.out.println("Vowel count :" + vowel);
        System.out.println("Consonant count: " + consonant);
        sc.close();

    }
}