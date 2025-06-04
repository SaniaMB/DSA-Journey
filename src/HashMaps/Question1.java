package HashMaps;
import java.util.*;

public class Question1 {
    public static void majorityElement(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else
                map.put(num, 1);
        }

        for( int key : map.keySet() ){
            if(map.get(key) > (nums.length/3))
                System.out.println(key);
        }

    }
    public static void main(String[] args) {
        // Given an integer of size n, find all the elements that appear more than n/3 times
        // nums[] = {1,3,2,5,1,3,1,5,1}
        // 1
        //nums[] = {1,2}
        //1,2

       int[] nums = {1,3,2,5,1,3,1,5,1};
       majorityElement(nums);

    }
}
