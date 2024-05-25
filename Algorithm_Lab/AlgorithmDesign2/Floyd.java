public class Floyd
{
    void floyd1(int n, const number W[][], number D[][])    
    {
        int i, j, k;
        D = W;
        for(k = 1; k <= n; k++)
        {
            for(i = 1; i <= n; i++)
            {
                for(j = 1; j <= n; j++)
                {
                    D[i][j] = minimum(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }
    }

    void floyd2(int n, const number W[][], number D[][], index P[][])
    {
        index i, j, k;

        for(i = 1; i <= n; i++)
        {
            for(j = 1; j <= n; j++)
            {
                P[i][j] = 0;
            }
        }

        D = W;

        for(k = 1; k <= n; k++)
        {
            for(i = 1; i <= n; i++)
            {
                for(j = 1; j <= n; j++)
                {
                    P[i][j] = k;
                    D[i][j] = minimum(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }
    }
}
