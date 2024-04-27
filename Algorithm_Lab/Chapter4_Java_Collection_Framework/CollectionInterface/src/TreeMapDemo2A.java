import java.util.*;

class CompLastNames implements Comparator<String> 
{
    public int compare(String aStr, String bStr) 
    {
        int i = aStr.lastIndexOf(' ');
        int j = bStr.lastIndexOf(' ');
        return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
    }
}

class CompThenByFirstName implements Comparator<String> 
{

    public int compare(String aStr, String bStr) 
    {
        return aStr.compareToIgnoreCase(bStr);  
    }
}

class TreeMapDemo2A 
{
    public static void main(String args[]) 
    {
        CompLastNames compLN = new CompLastNames();
        Comparator<String> compLastThenFirst = compLN.thenComparing(new CompThenByFirstName());
        TreeMap<String, Double> tm = new TreeMap<String, Double>(compLastThenFirst);
    }
}