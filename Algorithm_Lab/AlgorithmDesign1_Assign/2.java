//22113644 이승형

import java.util.*;

public class hw2 
{    
    static void Combination(int[] arr, int index, int size, int remainElement, int currentElement, List<List<Integer>> set)
    {
        if(remainElement == 0)
        {
            List<Integer> subset = new ArrayList<>();
            for(int i = 0; i < index; i++)
            {
                subset.add(arr[i]);
            }
            set.add(subset);
        }
        else if(currentElement == size)
        {
            return;
        }
        else
        {
            arr[index] = currentElement;
            Combination(arr, index + 1, size, remainElement - 1, currentElement + 1, set); //1~ -> 2~
            Combination(arr, index, size, remainElement, currentElement + 1, set); //1~ -> 1~
        }
    }

    public static void main(String[] args)
    {
        List<List<Integer>> set = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 n과 k를 입력: ");
        int n = scanner.nextInt();        
        int k = scanner.nextInt();

        int arr[] = new int[k];

        Combination(arr, 0, n + 1, k, 1, set);

        for (List<Integer> subset : set) 
        {
            System.out.println(subset);
        }
    }
}
