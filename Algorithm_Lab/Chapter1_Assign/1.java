//22113644 이승형
import java.util.ArrayList;
import java.util.List;

class Solution 
{
    public int[] solution(int[] numbers) 
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
}