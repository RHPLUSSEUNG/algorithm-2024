import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static int[] solution(int[] numbers)
    {        
        List<Integer> answerList = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++)
        {
            for(int j = i + 1; j < numbers.length; j++)
            {
                if(!answerList.contains(numbers[i] + numbers[j]))
                {
                    answerList.add(numbers[i] + numbers[j]);
                }                
            }            
        }
        answerList.sort(null);       
        int[] answer = new int[answerList.size()];

        for(int i = 0; i < answerList.size(); i++)
        {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
    
    public static void main(String[] args)
    {
        int[] numbers = {2, 1, 3, 4, 1};
        int[] answer = Solution.solution(numbers);
        for(int i = 0; i < answer.length; i++)
        {
            System.out.print(answer[i] + " ");
        }        
    }
}
