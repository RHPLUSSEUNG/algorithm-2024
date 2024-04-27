import java.util.*;

class ForEachDemo 
{
    public static void main(String args[]) 
    { 
    ArrayList<Integer> vals= new ArrayList<Integer>(); 
    vals.add(1);     vals.add(2);     vals.add(3);     vals.add(4);     vals.add(5); 
    System.out.print("Original contents of vals: "); 

    for (int v : vals) // for loop을이용해원소출력(순방향순회만지원& 수정불가)
     System.out.print(v + " "); 

    System.out.println(); 

    int sum = 0; 
    
    for (int v : vals) // Now, sum the values by using a for loop.
     sum += v; 

    System.out.println("Sum of values: " + sum); 
    }
}