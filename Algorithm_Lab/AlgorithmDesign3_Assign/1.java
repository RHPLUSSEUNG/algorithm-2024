//22113644 이승형
import java.util.Stack;

public class Solution 
{
    public String solution(String number, int k) 
    {
        Stack<Character> stack = new Stack<>();
        
        String answer = "";
        
        for (int i = 0; i < number.length(); i++) 
        {
            char numberChar = number.charAt(i);
            
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) 
            {
                stack.pop();
                k--;
            }
            stack.push(numberChar);
        }
        
        while (k > 0) 
        {
            k--;
            stack.pop();
        }
       
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) 
        {
            sb.append(stack.get(i));
        }

        answer = sb.toString();
        return answer;
    }
}