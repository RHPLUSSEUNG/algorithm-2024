//22113644 이승형

class Solution
{
    int zero = 0;
    int one = 0;

    public void Compression(int[][] arr, int startRow, int startCol, int size)
    {
        boolean isCompression = true;
        int comparison = arr[startRow][startCol];

        if(size == 1)
        {
            if(arr[startRow][startCol] == 0)
            {
                zero++;
            }
            else
            {
                one++;
            }

            return;
        }

        for(int i = startRow; i < startRow + size; i++)
        {
            for(int j = startCol; j < startCol + size; j++)
            {
                if(arr[i][j] != comparison)
                {
                    isCompression = false;
                    break;
                }                            
            }

            if(!isCompression)
            {
                break;
            }
        }

        if(isCompression)
        {
            if(comparison == 0)
            {
                zero++;
            }
            else
            {
                one++;
            }
        }
        else
        {
            int newSize = size / 2;
            Compression(arr, startRow, startCol, newSize);
            Compression(arr, startRow, startCol + newSize, newSize);
            Compression(arr, startRow + newSize, startCol, newSize);
            Compression(arr, startRow + newSize, startCol + newSize, newSize);
        }
    }

    public int[] solution(int[][] arr) 
    {
        Compression(arr, 0, 0, arr.length);
        int[] answer = {zero, one};
        return answer;
    }
}
