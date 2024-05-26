//22113644 이승형

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HW2 
{    
    public static int LCS(String X, String Y, int x_length, int y_length) 
    {            
        int answer = 0;
        int[][] lcsLength = new int[x_length + 1][y_length + 1];                       

        for(int i = 1; i < x_length + 1; i++)
        {            
            for(int j = 1; j < y_length + 1; j++)
            {
                if(X.charAt(i-1) == Y.charAt(j-1))
                {                    
                    lcsLength[i][j] = lcsLength[i-1][j-1] + 1;            
                }
                else
                {
                    lcsLength[i][j] = Math.max(lcsLength[i-1][j], lcsLength[i][j-1]);
                }                
            }            
        }

        answer = lcsLength[x_length][y_length];

        char[] lcsString = new char[answer];
        int index = answer - 1;
        
        while (x_length > 0 && y_length > 0) 
        {
            if (X.charAt(x_length-1) == Y.charAt(y_length-1)) 
            {
                lcsString[index] = X.charAt(x_length-1);
                index--;
                x_length--;
                y_length--;
            } 
            else if (lcsLength[x_length-1][y_length] >= lcsLength[x_length][y_length-1]) 
            {
                x_length--;
            }
            else 
            {
                y_length--;
            }
        }
                      
        for(int i = 0; i < lcsString.length; i++)
        {
            System.out.print(lcsString[i]);
        }

        System.out.println();

        return answer;
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String X = br.readLine();        
        String Y = br.readLine();

        int lcsLength = LCS(X, Y, X.length(), Y.length());
        System.out.println("LCS Length: " + lcsLength);
    }
}