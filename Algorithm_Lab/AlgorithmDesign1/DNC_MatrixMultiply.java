public class DNC_MatrixMultiply 
{
    void matrixmult(int n, const int A[][], const int B[][], int C[][])    
    {
        index i, j, k;

        for(i = 0; i < n; i++)
        {
            for(j = 0; j < n; j++)
            {
                C[i][j] = 0;

                for(k = 0; k < n; k++)
                {
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }
    }

    void strassen(int n, n*n_matrix A, n*n_matrix B, n*n_matrix C)
    {
        if(n <= threshold)
        {
            //단순히 알고리즘을 사용
            void matrixmult(n, A, B, C);
        }
        else
        {
            //A를 4개의 부분 행렬 A11, A12, A21, A22로 분할
            //B를 4개의 부분 행렬 B11, B12, B21, B22로 분할
            //Strassen의 방법을 사용하여 C = A * B 계산
            //되부르는 호출 예: strassen(n/2, A11+A12, B11+B22, M1);
        }
    }
}
