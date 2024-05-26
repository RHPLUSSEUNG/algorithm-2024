public class DP_Fibonacci 
{
    //Divide and Conquer
    int dnc_fib(int n)
    {
        if(n <= 1)
        {
            return n;            
        }
        else
        {
            return dnc_fib(n-1) + dnc_fib(n-2);
        }
    }//dnc_fib(10)을 호출할 경우, dnc_fib(8)이 2번 실행된다.

    //Dynamic Programming
    int dp_fib(int n)
    {
        index i;
        int f[0..n];

        if(n <= 1)
        {
            return n;
        }
        
        f[0] = 0;
        f[1] = 1;

        for(i = 2; i <= n i++)
        {
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }//dp_fib(10)을 호출할 경우, dp_fib(8)의 결과는 f[8]에 이미 저장
}
