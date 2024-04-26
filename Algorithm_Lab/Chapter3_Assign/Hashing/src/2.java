//22113644 이승형
import java.util.HashMap;

class Solution 
{    
    public boolean solution(String[] phone_book) 
    {
        HashMap<String, String> phone_book_map = new HashMap<String, String>();
        boolean answer = true;
        
        for(int i = 0; i < phone_book.length; i++)
        {
            phone_book_map.put(phone_book[i], "");
        }

        for(int i = 0; i < phone_book.length; i++)
        {
            String s = phone_book[i];    

            for(int j = 0; j < s.length(); j++)
            {
                if(phone_book_map.containsKey(s.substring(0, j)))
                {
                    answer = false;
                    return answer;
                }
            }            
        }
        
        return answer;
    }
}