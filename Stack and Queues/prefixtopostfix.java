import java.util.*;
public class prefixtopostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        Stack<String> st = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                st.push(String.valueOf(s.charAt(i)));
            }
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                StringBuilder ans = new StringBuilder();
                ans.append(t1);
                ans.append(t2);
                ans.append(s.charAt(i));
                st.push(ans.toString());
            }
        }
        System.out.println(st.peek());
    }
}

