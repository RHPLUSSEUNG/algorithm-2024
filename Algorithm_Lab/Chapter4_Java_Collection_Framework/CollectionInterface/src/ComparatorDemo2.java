import java.util.*;

class MyComp implements Comparator<String>
{

    public int compare(String aStr, String bStr) 
    {  
        return aStr.compareTo(bStr);  // natural ordering
    }
}

public class ComparatorDemo2 
{
    public static void main(String args[]) 
    {
        MyComp mc = new MyComp();
        TreeSet<String> ts = new TreeSet<String>(mc.reversed());
        // Add elements to the tree set.
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        System.out.println(ts);
    }
}