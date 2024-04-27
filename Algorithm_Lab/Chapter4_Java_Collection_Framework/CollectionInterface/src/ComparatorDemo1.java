import java.util.*;

class MyComp implements Comparator<String>
{

    public int compare(String aStr, String bStr)
    {  
        return bStr.compareTo(aStr);  // Reverse the comparison. 
    }
}

public class ComparatorDemo1 
{
    public static void main(String args[]) 
    {
        TreeSet<String> ts = new TreeSet<String>(new MyComp());
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