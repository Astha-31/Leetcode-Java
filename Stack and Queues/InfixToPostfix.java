import java.util.*;
public class InfixToPostfix {
    
    private static int priority(char c){
        if( c == '^')return 3;
        else if(c == '*' || c == '/') return 2;
        else if(c == '+' || c == '-') return 1;
        else return -1;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; i++){
            if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                ans.append(s.charAt(i));
            }

            else if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans.append(st.peek());
                    st.pop();
                }
                if (!st.isEmpty()) st.pop();
                
            }
            else{
                
                    while(!st.isEmpty() && priority(st.peek()) >= priority(s.charAt(i))){
                        ans.append(st.peek());
                        st.pop();
                    }
                    st.push(s.charAt(i));
                }
            }
        

        while(!st.isEmpty()){
            ans.append(st.peek());
            st.pop();
        }
        System.out.println((ans));
    }
}

