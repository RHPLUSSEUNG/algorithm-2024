//22113644 이승형

class Solution 
{
    public static int solution(int[][] triangle) 
    {
        int answer = 0;        
        int n = triangle.length;
        int[][] route = new int[n][n];
        
        route[0][0] = triangle[0][0];

        for(int i = 1; i < n; i++)
        {
            route[i][0] = route[i-1][0] + triangle[i][0];

            for(int j = 1; j < i + 1; j++)
            {
                route[i][j] = Math.max(route[i-1][j-1], route[i-1][j]) + triangle[i][j];                
            }
        }

        for(int i = 0; i < n; i++)
        {
            if(answer < route[n-1][i])
            {
                answer = route[n-1][i];
            }
        }

        return answer;
    }
}