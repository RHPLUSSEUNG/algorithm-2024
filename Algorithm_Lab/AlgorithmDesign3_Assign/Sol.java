import java.util.*;

public class Sol 
{

    public static int solution(int[][] routes) 
    {
        ArrayList.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int camera = 0;
        int cameraPosition = Integer.MIN_VALUE;
        
        for (int[] route : routes) 
        {
            if (cameraPosition < route[0]) 
            {
                camera++;
                cameraPosition = route[1];
            }
        }

        return camera;
    }

    public static void main(String[] args) 
    {
        int[][] routes = { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };

        int answer = solution(routes);

        System.out.println(answer);
    }
}