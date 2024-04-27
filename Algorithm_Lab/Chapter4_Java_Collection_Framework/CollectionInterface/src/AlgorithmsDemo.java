import java.util.*;

public class AlgorithmsDemo 
{
    public static void main(String args[]) 
    {
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("C");
        ll.add("A");
        ll.add("E");
        ll.add("D");
        ll.add("A");
        Comparator<String> r = Collections.reverseOrder(); // 역순의comparator 생성
        Collections.sort(ll, r); // Sort list by using the comparator
        System.out.println("List sorted in reverse: " + ll);
        Collections.shuffle(ll); // Shuffle list
        System.out.println("List shuffled: " + ll);
        System.out.println("Minimum: " + Collections.min(ll));
        System.out.println("Maximum: " + Collections.max(ll));
        System.out.println("A의빈도수: " + Collections.frequency(ll, "A"));
    }
}