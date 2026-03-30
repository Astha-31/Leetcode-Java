import java.util.*;
class Solution {
    private static String remove(String s){
        int n = s.length();
        if(n <= 1) return s;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(i == 0 && s.charAt(i) == s.charAt(i+ 1)) continue;
            else if( i < n - 1 && i > 0 && (s.charAt(i) == s.charAt(i + 1) || s.charAt(i) == s.charAt(i - 1))){
                continue;
            }
            else if(i == n - 1 && n > 1 && s.charAt(i) == s.charAt(i-1)) continue;
            else
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while(true){
            String sb = remove(s);
            if(s.equals(sb)) break;
            s = sb;
        }
        sc.close();
        System.out.println(s);
    }
}