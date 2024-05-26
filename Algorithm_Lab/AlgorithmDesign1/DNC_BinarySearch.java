public class DNC_BinarySearch {

    index location(index low, index high) 
    {
        index mid;

        if (low > high)
         {
            return -1;
        } 
        else
         {
            mid = (low + high) / 2;

            if (x == S[mid]) // recursion을 이용하므로 x와 S[]는 global 변수로 선언. local 변수로 선언하면 메모리 낭비가 심하다.
            {
                return mid;
            }
            else if (x < S[mid]) 
            {
                return location(low, mid + 1);
            } 
            else 
            {
                return location(mid + 1, high);
            }
        }
    }
    // ...
    // locationout = location(0, n-1);
    // ...
}