import java.util.*;

class ArrayListToArray 
{
    public static void main(String args[]) 
    {
        ArrayList<Integer> al = new ArrayList<Integer>(); // Integer array list를생성
        // array list에원소추가autoboxing
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        System.out.println("Contents of al: " + al);
        Integer ia[] = new Integer[al.size()]; // 사이즈를 작게 만들어도 들어올 원소에 맞춰 사이즈 변경
        ia = al.toArray(ia); // toArray() 함수를이용하여array list의내용을배열에저장
        int sum = 0;
        for (int i : ia) // Sum the array.
            sum += i;
        System.out.println("Sum is: " + sum);
    }
}