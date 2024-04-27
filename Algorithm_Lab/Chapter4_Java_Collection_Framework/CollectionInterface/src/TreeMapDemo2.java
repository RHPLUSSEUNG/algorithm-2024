import java.util.*;

class TComp implements Comparator<String> 
{

    public int compare(String aStr, String bStr) 
    {
        int i, j, k;
        i = aStr.lastIndexOf(' '); // Last name의앞공백문자의위치
        j = bStr.lastIndexOf(' ');
        k = aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
        return (k == 0) ? aStr.compareToIgnoreCase(bStr) : k;
    }
}

class TreeMapDemo2 
{
    public static void main(String args[]) 
    {
        TreeMap<String, Double> tm = new TreeMap<String, Double>(new TComp());
    }
}