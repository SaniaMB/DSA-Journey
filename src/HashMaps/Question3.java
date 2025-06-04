package HashMaps;
import java.util.*;

public class Question3 {
    public static int intersection(int[] arr1 , int[] arr2) {

        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for (int i : arr1)
            set.add(i);

        for (int j : arr2) {
            if (set.contains(j)) {
                count++;
                set.remove(j);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // Question on intersection
        // arr1 = {7,3,9}
        // arr2 = {6,3,9,2,9,4}
       // output = 2 (3,9)

       int[] arr1 = {7,3,9};
       int[] arr2 = {6,3,9,2,9,4};

        System.out.println(intersection(arr1,arr2));

    }
}
