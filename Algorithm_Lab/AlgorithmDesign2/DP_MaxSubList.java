public class DP_MaxSubList
{
    public static double maxSubList(double[] A, int n)
    {
        double[] B;
        double max;

        B = new double[n];
        max = B[0] = A[0];
        int start = 0;
        int indexLength = 0;

        for(int i = 1; i < n; i++)
        {
            //B[i] = (B[i-1] <= 0) ? A[i] : B[i-1] + A[i];

            if(B[i-1] <= 0)
            {
                B[i] = A[i];
                indexLength = 0;
            }
            else
            {
                B[i] = B[i-1] + A[i];
            }
            
            indexLength++;

            if(max < B[i])
            {
                max = B[i];
                start = i;                
            }
        }

        for(int i = start - indexLength + 2; i <= start; i++)
        {
            System.out.println(A[i]);
        }
        return max;
    }

    public static void main(String[] args)
    {
        double[] ex = {2.3, 3.2, -4.5, 2.1, -5.3, 3.6, 4.1, -2.3, 3.5, -4.5};
        int n = ex.length;

        maxSubList(ex, n);
    }
}