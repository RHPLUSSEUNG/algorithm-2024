import java.util.*;

class TreeSetDemo 
{
    public static void main(String args[]) 
    {
        TreeSet<String> ts = new TreeSet<String>(); // Create a tree set.
        // Add elements to the tree set.
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        System.out.println(ts);
        System.out.println(ts.subSet("C", "F")); // NavigableSet의method.
    }
}