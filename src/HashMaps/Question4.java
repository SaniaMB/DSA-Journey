package HashMaps;
import java.util.*;

public class Question4 {
    public static String getStart(HashMap<String,String> map){
        HashMap<String,String> revMap = new HashMap<>();

        for (String key : map.keySet()){
           // key -> key , val -> map.get(key);
            revMap.put(map.get(key),key);
        }

        for(String  key : map.keySet()){
            if(!revMap.containsKey(key))
                return key;
        }

        return null;
    }
    public static void main(String[] args) {
//      Find Itinerary from tickets
//        chennai -> bengaluru
//        mumbai -> delhi
//        goa -> chennai
//        delhi -> goa
//    output : mumbai -> delhi -> goa -> chennai -> bengaluru

        HashMap<String,String> map1 = new HashMap<>();

        map1.put("chennai","bengaluru");
        map1.put("mumbai","delhi");
        map1.put("goa","chennai");
        map1.put("delhi","goa");

        String start = getStart(map1);

        while(map1.containsKey(start)){
            System.out.print(start+" -> ");
            start = map1.get(start);
        }
        System.out.println(start);

    }
}
