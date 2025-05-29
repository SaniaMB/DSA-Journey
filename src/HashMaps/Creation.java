package HashMaps;
import java.util.*;

public class Creation {
    public static void main(String[] args) {
        //country(Key),population(value)
        HashMap<String, Integer> map = new HashMap<>();

        //Insertion
        map.put("India", 20);
        map.put("Us", 100);
        map.put("China", 90);
        map.put("China", 180);

        System.out.println(map);

        //search
        if (map.containsKey("China"))
            System.out.println("Key is present in the map");
        else
            System.out.println("Key is not present in the map");

        System.out.println(map.get("China"));
        System.out.println(map.get("Indonesia"));

        int[] arr = {1, 2, 3, 4, 5};

        for (int val : arr) {
            System.out.print(val);
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        Set<String> keys = map.keySet();
        for (String Key : keys)
            System.out.println(Key = "" + map.get(Key));

        map.remove("China");
        System.out.println(map);
    }
}