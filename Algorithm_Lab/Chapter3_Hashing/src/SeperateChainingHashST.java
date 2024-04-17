import java.util.ArrayList;

public class SeperateChainingHashST<K, V>
{
    private int N; //테이블에 입력된 원소의 수
    private int M; //해시 테이블의 크기
    private SequentialSearchST<K, V>[] st; //순차연결리스트의 배열로 테이블 구성

    public SeperateChainingHashST()
    {
        this(997); //default: 소수
    }

    public SeperateChainingHashST(int M) //M을 입력받는 생성자
    {
        this.M = M;
        st = (SeperateChainingHashST<K,V>[]) new SequentialSearchST[M];
        
        for(int i = 0; i < M; i++)
        {
            st[i] = new SequentialSearchST<K, V>();
        }        
    }

    public boolean contains(K keys)
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

    private int hash(K key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public V get(K key) //리스트를 검색
    {
        return st[hash(key)].get(key);
    }

    public void put(K key, V value) //리스트에 추가
    {
        if(!contains(key))
        {
            N++;
        }

        st[hash(key)].put(key, value);        
    }

    public void delete(K key) //리스트에서 삭제
    {
        if(!contains(key))
        {
            return;
        }

        st[hash(key)].delete(key);
        N--;
    }

    public Iterable<K> keys() //각 원소의 리스트를 모두 포함
    {
        ArrayList<K> keyList = new ArrayList<K>(N);

        for(int i = 0; i < M; i++)
        {
            for(K key : st[i].keys())
            {
                keyList.add(key);
            }            
        }

        return keyList;
    }
}
