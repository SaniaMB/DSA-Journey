package HashMaps;
import java.util.*;

public class Question5 {
    public static void main(String[] args) {
        // Contiguous subarray sum equals to K
        // arr = {1,2,3}, k = 3
        // output : 2(1,2)
        // arr = {10,2,-2,-20,10}, k = -10
        // output : 3

        int[] arr = {10,2,-2,-20,10};
        int k = -10;

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1);
        int ans = 0;
        int sum = 0;

        for(int j : arr){
            sum += j;
            if(map.containsKey(sum-k))
                ans += map.get(sum-k);

            if(map.containsKey(sum))
                map.put(sum, map.get(sum)+1);
            else
                map.put(sum,1);
        }

        System.out.println(ans);
    }
}
