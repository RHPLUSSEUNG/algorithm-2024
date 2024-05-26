public class DNC_QuickSort 
{
    void quickSort(index low, index high)
    {
        index pivotpoint;

        if(high > low)
        {
            pivotpoint = partition(low, high);
            quickSort(low, pivotpoint - 1);
            quickSort(pivotpoint + 1, high);
        }
    }

    index partition(index low, index high)
    {
        index i, j, pivotpoint;
        keytype pivotitem;
        pivotitem = S[low];
        j = low;

        for(i = low + 1; i <= high; i++)
        {
            if(S[i] < pivotitem)
            {
                j++;
                //exchange S[i] and S[j];
            }        
        }

        pivotpoint = j;

        //exchange S[low] and S[pivotpoint];
        return pivotpoint;        
    }
}
