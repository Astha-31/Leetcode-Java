import java.util.*;
public class postfixtoprefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        Stack<String> st = new Stack<>();
        for(int i = 0; i < n; i++){
            if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                st.push(String.valueOf(s.charAt(i)));
            }
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                StringBuilder ans = new StringBuilder();
                ans.append(s.charAt(i));
                ans.append(t2);
                ans.append(t1);
                st.push(ans.toString());
            }
        }
        System.out.println(st.peek());
    }
}
