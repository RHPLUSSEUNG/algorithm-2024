public class MergeTD extends AbstractSort
{
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        for(int k =lo; k <= hi; k++)
        {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;

        for(int k = lo; k <= hi; k++)
        {
            if(i > mid)
            {
                a[k] = aux[j++];                
            }
            else if(j > hi)
            {
                a[k] = aux[i++];
            }
            else if((less(aux[j], aux[i])))
            {
                a[k] = aux[j++];
            }
            else
            {
                a[k] = aux[i++];
            }
        }
    }

    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);        
    }
    
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
        if(hi <= lo)
        {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(aux, a, lo, mid); //아래 부분 정렬 , aux와 a의 역할 switch
        sort(aux, a, mid + 1, hi); //윗 부분 정렬
        merge(aux, a, lo, mid, hi); //두 부분 병합
    }
}
