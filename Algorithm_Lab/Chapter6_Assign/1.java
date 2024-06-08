//22113644 이승형
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main 
{    
    public static void sort(String[] str) 
    {        
        TreeSet<String> set = new TreeSet<String>(Arrays.asList(str));
        
        String[] result = set.toArray(new String[0]);
        
        Arrays.sort(result, (String a, String b) -> a.length() - b.length());
        
        for(int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for(int i = 0; i < n; i++)
        {
            str[i] = br.readLine();
        }
                        
        sort(str);
    }
}