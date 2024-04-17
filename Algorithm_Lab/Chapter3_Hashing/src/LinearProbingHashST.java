public class LinearProbingHashST<K, V>
{
    private int N;
    private int M; //항상 M > N을 만족하여야 함
    private K[] keys; //키를 저장하는 배열
    private V[] vals; //값를 저장하는 배열

    pulic LinearProbingHashST()
    {
        this(31);
    }

    public LinearProbingHashST(int M)
    {
        keys = (K[]) new Object[M];
        vals = (V[]) new Object[M];
        this.M = M;
    }

    public boolean contains(K key)
    {
        return get(key) != null;        
    }

    public bollean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    private int hash(K key)
    {
        return (key.hashCode() & 0x7fffffff) % M; //양수로 바꿈
    }

    public V get(K key)
    {
        for(int i = hash(key); keys[i] != null; i = (i+1) % M) //테이블 순회
        {
            if(keys[i].equals(key)) //search hit
            {
                return vals[i];
            }
        }

        return null; //search miss
    }

    public void put(K key, V value)
    {
        if(N >= M / 2)
        {
            resize(2 * M + 1); //테이블 재구성, 심볼 테이블은 소수에 맞춰져 있으므로 홀수(2*M+1)       
        }

        int i;

        for(i = hash(key; keys[i] != null; i = (i+1) % M))
        {
            if(keys[i].equals(key)) //기존에 존재하는 키
            {
                vals[i] = value;
                return;
            }
        }

        keys[i] = key; //새로(키, 값)의 쌍을 추가
        vals[i] = value;
        N++;
    }

    private void resize(int cap)
    {
        LinearProbingHashST<K, V> t;
        t = new LinearProbingHashST<>(cap);

        for(int i = 0; i < M; i++) //새로운 테이블에 모든 원소 추가
        {
            if(keys[i] != null)
            {
                t.put(keys[i], vals[i]);
            }
        }
    }

    keys = t.keys;
    vals = t.vals;
    M = t.M;
}
