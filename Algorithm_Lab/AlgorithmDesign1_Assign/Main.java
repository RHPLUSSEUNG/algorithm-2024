import java.util.*;

class Main 
{
    static void combination(int[] arr, int index, int size, int remain, int target, List<List<Integer>> result) 
    {
        if (remain == 0) 
        {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < index; i++)
            {
                subset.add(arr[i]);
            }
            result.add(subset);
        } 
        else if (target == size) 
        {
            return;
        } 
        else 
        {
            arr[index] = target;
            combination(arr, index + 1, size, remain - 1, target + 1, result);
            combination(arr, index, size, remain, target + 1, result);
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 n을 입력: ");
        int n = scanner.nextInt();
        System.out.print("정수 k를 입력: ");
        int k = scanner.nextInt();
        int[] arr = new int[k];
        List<List<Integer>> result = new ArrayList<>();
        combination(arr, 0, n + 1, k, 1, result);
        for (List<Integer> subset : result) 
        {
            System.out.println(subset);
        }
    }
}
