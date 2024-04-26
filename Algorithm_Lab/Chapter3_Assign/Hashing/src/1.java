//22113644 이승형
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

        HashMap<String, Integer> diffString = new HashMap<String, Integer>();              

        for (int i = 1; i <= input.length(); i++) 
        {
            for (int j = 0; j + i <= input.length(); j++) 
            {
                diffString.put(input.substring(j, j + i), 1);
            }
        }
        
        System.out.println(diffString.size());

        br.close();
    }
}
