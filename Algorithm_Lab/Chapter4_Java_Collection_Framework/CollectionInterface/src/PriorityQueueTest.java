import java.util.*;

public class PriorityQueueTest 
{
    public static void main(String[] args) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // natural ordering
        pq.add(30);
        pq.add(80);
        pq.add(20);
        // pq.add(10);
        // pq.add(5);
        System.out.println(pq);
        System.out.println("원소삭제");
        while (!pq.isEmpty())
            System.out.println(pq.remove());
    }
}