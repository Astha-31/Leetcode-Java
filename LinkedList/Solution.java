import java.util.*;

public class Solution {
    public static int countValidDevicePairs(int n, List<Integer> ids) {
        
        int p = 0;
        for(int i = 0; i < ids.size() ; i++){
            for(int j = i +1; j < ids.size(); j++){
                int xor = ids.get(i) ^ ids.get(j);
                if(xor == 1) p++;

                if(xor >= 1 && (xor & (xor - 1)) == 0) p++;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 8);
        int n = ids.size();
        System.out.println(countValidDevicePairs(n, ids)); 
    }
}