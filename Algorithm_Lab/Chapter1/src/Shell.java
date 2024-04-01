public class Shell extends AbstractSort
{

    public static void sort(Comparable[] a) 
    {
        int N = a.length;
        int h = 1;
        while (h < N / 3)
        {
            h = 3 * h + 1; //간격 h를 3*h + 1이 N/3보다 작을 때까지 증가시킵니다. 이렇게 하면 h는 1, 4, 13, 40, ...과 같은 수열을 따름
        }            
        while (h >= 1)  //간격 h가 1 이상일 때까지 다음을 반복:
        {
            for (int i = h; i < N; i++)
            {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                {
                    exch(a, j, j - h); //h 간격으로 이루어진 부분 배열을 정렬합니다. 이는 h 간격으로 떨어진 요소를 비교하고 필요에 따라 교환(삽입 정렬)
                }
            }
                
            h /= 3;
        }
    }

    public static void main(String[] args) 
    {
        Integer[] a = { 10, 4, 5, 2, 1, 8, 3, 6 };
        Shell.sort(a);
        Shell.show(a);
    }
}
