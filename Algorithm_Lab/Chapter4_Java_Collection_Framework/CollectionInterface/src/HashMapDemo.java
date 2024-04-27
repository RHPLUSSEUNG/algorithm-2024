import java.util.*;

class HashMapDemo 
{
    public static void main(String args[]) 
    {
        HashMap<String, Double> hm = new HashMap<String, Double>();
        hm.put("John Doe", new Double(3434.34)); // Map에(키, 값) 쌍추가
        hm.put("Tom Smith", new Double(123.22));
        hm.put("Jane Baker", new Double(1378.00));
        hm.put("Tod Hall", new Double(99.22));
        hm.put("Ralph Smith", new Double(-19.08));
        // Map에저장된쌍들을모두출력
        Set<Map.Entry<String, Double>> set = hm.entrySet();

        for (Map.Entry<String, Double> me : set)
            System.out.println(me.getKey() + ": " + me.getValue());
            
        // John Doe의계정에1000원을추가
        double balance = hm.get("John Doe");
        hm.put("John Doe", balance + 1000);
        System.out.println("New balance: " + hm.get("John Doe"));
    }
}