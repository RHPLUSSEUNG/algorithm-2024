public class DP_BinomialCoefficient 
{
    //Divide and Conquer
    int dnc_bin(int n, int k)
    {
        if(k == 0 || n == k)
        {
            return 1;
        }
        else
        {
            return dnc_bin(n-1, k-1) + bin(n-1, k);
        }
    }

    //Dynamic Programming
    int dp_bin(int n, int k)
    {
        index i, j;
        int B[0..n][0..k];

        for(i = 0; i <= n; i++)
        {
            for(j = 0; j <= minimum(i, k); j++)
            {
                if(j == 0 || j == i)
                {
                    B[i][j] = 1;
                }
                else
                {
                    B[i][j] = B[i-1][j-1] + B[i-1][j];
                }
            }
        }

        return B[n][k];
    }
}
