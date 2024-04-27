import java.util.*;

class ArraysDemo 
{
    public static void main(String args[]) 
    {
        int array[] = new int[8];
        for (int i = 0; i < 8; i++)
            array[i] = -3 * i;
        // 배열초기화
        // Display, sort, and display the array.
        System.out.print("Original contents: ");
        display(array);
        Arrays.sort(array);
        System.out.print("Sorted: ");
        display(array);
        // Fill and display the array.
        Arrays.fill(array, 2, 6, -1);
        System.out.print("After fill(): ");
        display(array);
        // Sort and display the array.
        Arrays.sort(array);
        System.out.print("After sorting again: ");
        display(array);
        // Binary search for -3.
        System.out.print("-3의위치: ");
        int index = Arrays.binarySearch(array, -3);
        System.out.println(index);
    }

    static void display(int array[]) 
    {
        for (int i : array)
            System.out.print(i + " ");
        System.out.println();
    }
}