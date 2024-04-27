import java.util.*;

class ArrayListDemo 
{
    public static void main(String args[]) 
    {
        ArrayList<String> al = new ArrayList<String>(); // 비어있는array list 생성
        System.out.println("Initial size of al: " + al.size());
        // array list에원소추가
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1, "A2");
        System.out.println("Size of al after additions: " + al.size());
        System.out.println("Contents of al: " + al); // array list의내용출력. toString()
        al.remove("F");
        al.remove(2); // array list에서원소삭제
        System.out.println("Size of al after deletions: " + al.size());
        System.out.println("Contents of al: " + al);
    }
}