import java.util.*;

class IteratorDemo 
{
    public static void main(String args[]) 
    {
        ArrayList<String> al = new ArrayList<String>();
        // Array list에원소추가
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        // Iterator를이용하여al의내용출력
        System.out.print("Original contents of al: ");
        Iterator<String> itr = al.iterator();
        
        while (itr.hasNext()) 
        {
            String element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // 순회하면서원소들을수정
        ListIterator<String> litr = al.listIterator();

        while (litr.hasNext()) 
        {
            String element = litr.next();
            litr.set(element + "+"); // 현재위치의원소수정
        }
        System.out.print("Modified contents of al: ");

        itr = al.iterator();

        while (itr.hasNext()) 
        {
            String element = itr.next();
            System.out.print(element + " ");
        }        
        System.out.println();

        // 역순으로순회하면서출력
        System.out.print("Modified list backwards: ");

        while (litr.hasPrevious()) 
        { // litr은현재마지막에..
            String element = litr.previous();
            System.out.print(element + " ");
        }
        System.out.println();
    }
}