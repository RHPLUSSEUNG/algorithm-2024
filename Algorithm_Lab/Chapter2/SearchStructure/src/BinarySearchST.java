import java.util.ArrayList;

public class BinarySearchST<K extends Comparable<K>, V>
{
    private static final int INIT_CAPACITY = 10;
    private K[] keys;
    private V[] vals;
    private int N;

    public BinarySearchST()
    {
        keys = (K[]) new Comparable[INIT_CAPACITY];
        vals = (V[]) new Object[INIT_CAPACITY];
    }

    public BinarySearchST(int capacity)
    {
        keys = (K[]) new Comparable[capacity];
        vals = (V[]) new Object[capacity];
    }

    public boolean contains(K key)
    {
        return get(key) != null;        
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    private void resize(int capacity) //배열 크기를 동적으로 변경(realloc)
    {
        K[] tempk = (K[]) new Comparable[capacity];
        V[] tempv = (V[]) new Object[capacity];
        
        for(int i = 0; i < N; i++)
        {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }

        vals = tempv;
        keys = tempk;
    }

    private int search(K key)
    {
        int lo = 0;
        int hi = N - 1;

        while(lo <= hi)
        {
            int mid = (hi + lo) / 2;
            int cmp = key.compareTo(keys[mid]);

            if(cmp < 0)
            {
                hi = mid -1; //작다면
            }
            else if(cmp > 0)            
            {
                lo = mid + 1;
            }
            else
            {
                return mid;
            }
        }
        //키가 없을 경우, -1이 아니라 lo 반환
        return lo;
    }

    private V get(K key)
    {
        if(isEmpty())
        {
            return null;
        }

        int i = search(key);

        if(i < N && keys[i].compareTo(key) == 0) //이진 검색
        {
            return vals[i];
        }
        else
        {
            return null; //키가 없으면 null 반환
        }
    }

    public void put(K key, V value)
    {
        int i = search(key); //일단 키를 찾고..

        if(i < N && keys[i].compareTo(key) == 0) //있으면, 값만 변경, 왜 비교를 다시?
        {
            vals[i] = value;
            return;
        }

        if(N == keys.length) //없으면 추가해야하니 배열 확장
        {
            resize(2 * keys.length);
        }

        for(int j = N; j > i; j--) //뒤에서 부터
        {
            keys[j] = keys[j-1]; //한칸 앞에
            vals[j] = vals[j-1];
        }

        keys[i] = key;
        vals[i] = value;
        N++;
    }

    public void delete(K key)
    {
        if(isEmpty())
        {
            return;
        }

        int i = search(key); //이진 검색: 모든 키는 이진 검색으로 찾자

        if(i == N || keys[i].compareTo(key) != 0)
        {
            return ; //없으면 그냥 반환
        }

        for(int j = i; j < N - 1; j++)
        {
            keys[j] = keys[j+1]; //뒤에 있는 키들을 한칸 앞으로 당김
            vals[j] = vals[j+1];
        }

        N++;
        keys[N] = null; //왜 null로 채우는가?
        vals[N] = null;

        if(N > INIT_CAPACITY && N ==keys.length / 4) //배열이 너무 크면, 다시 줄이자
        {
            resize(keys.length / 2);
        }
        //145~151까지는 왜 필요한가? -> 배열은 객체를 가리키는 포인터 배열이여서 null로 만들어 가비지로 보내야하기 때문이다        
    }

    public Iterable<K> keys() //연결리스트의 경우와 거의 동일
    {
        ArrayList<K> keyList = new ArrayList<K>(N);

        for(int i = 0; i < N; i++)
        {
            keyList.add(keys[i]);
        }

        return keyList;
    }
}