import java.util.*;

public class LinkedHashMapDemo 
{
    public static void main(String[] args) 
    {
        Map<String, Double> lhm = new LinkedHashMap<String, Double>();
        lhm.put("Apple", new Double(91.98));
        lhm.put("Sony", new Double(16.76));
        lhm.put("Dell", new Double(30.47));
        lhm.put("HP", new Double(33.91));

        System.out.println("Map contents : " + lhm); // 입력된순서대로출력

        for (String key : lhm.keySet())
            System.out.println(key + ":\t" + lhm.get(key)); // toString()과동일한순서

        System.out.println("\nThesize of Map is : " + lhm.size());
        System.out.println("Is Map empty? : " + lhm.isEmpty());
        System.out.println("Map contains Sony as key? : " + lhm.containsKey("Sony"));
        System.out.println("\nRemoveentry for Dell : " + lhm.remove("Dell"));
        System.out.println("Content of Map removing Dell: " + lhm);
        lhm.clear();
        System.out.println("Content of Map after clearing: " + lhm);
    }
}