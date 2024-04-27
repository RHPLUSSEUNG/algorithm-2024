import java.util.*;

class HashSetDemo 
{
    public static void main(String args[]) 
    {
        HashSet<String> hs = new HashSet<String>(); // Create a hash set.
        // Add elements to the hash set.
        hs.add("Beta");
        hs.add("Alpha");
        hs.add("Eta");
        hs.add("Gamma");
        hs.add("Epsilon");
        hs.add("Omega");
        System.out.println(hs); //Linked Hash Set은 입력된 순서
    }
}