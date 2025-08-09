import java.util.*;
public class smallerele{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ans = new int[n];
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = sc.nextInt();
        }
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && s.peek() >= ans[i]){
                s.pop();
            }
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(ans[i]);
        }

        for(int i = 0; i < n; i++){
            System.out.println(res[i]);
        }
    }

}