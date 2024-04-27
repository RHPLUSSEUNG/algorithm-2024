import java.util.*;

class LinkedListDemo 
{
    public static void main(String args[]) 
    {
        LinkedList<String> ll = new LinkedList<String>(); // linked list 생성
        // linked list에원소추가: Collection과List, Deque의함수를모두사용
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");
        ll.add(1, "A2");
        System.out.println("Original contents of ll: " + ll);
        ll.remove("F");
        ll.remove(2); // linked list에서원소삭제: Collection, List
        System.out.println("Contents of llafter deletion: " + ll);
        ll.removeFirst();
        ll.removeLast(); // 처음과마지막원소삭제: Deque
        System.out.println("llafter deleting first and last: " + ll);
        String val = ll.get(2); // Get and set a value <- 순차검색!
        ll.set(2, val + " Changed");
        System.out.println("llafter change: " + ll);
    }
}