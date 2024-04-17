import java.util.ArrayList;

class Node<K, V>
{
    K key; V value; Node<K, V> next;
    
    public Node(K key, V value, Node<K, V> next)
    {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

public class SequentialSearchST<K, V>
{
    private Node<K, V> first; //시작노드의 주소
    int N; //노드의 개수를 넣으면 return N;

    public V get(K Key) 
    {
        for(Node<K, V> x = first; x != null; x = x.next) //연결리스트 스캔
        {
            if(keys().equals(x.key))
            {
                return x.value; //hit
            }
        }

        return null; //miss
    }

    public void put(K key, V value) 
    {
        for(Node<K, V> x = first; x != null; x = x.next)
        {
            if(key.equals(x.key)) //키가 있으면 값만 변경
            {
                x.value = value;
                return;
            }
        }

        first = new Node<K, V>(key, value, first); //키가 없다면 앞에 노드 추가 (next를 first로)
        N++;
    }

    public void delete(K key) 
    {
        if(key.equals(first.key)) //첫번째 노드가 같은지 검사, 삭제
        {
            first = first.next;
            N--;
            return;            
        }

        for(Node<K, V> x = first; x.next != null; x = x.next) //삭제 할 노드 검사, x.next != null
        {
            if(key.equals(x.next.key))
            {
                x.next = x.next.next;
                N--;
                return;
            }
        }
    }

    public Iterable<K> keys() 
    {
        ArrayList<K> keyList = new ArrayList<K>(N); //ArrayList는 Iterable을 구현

        for(Node<K, V> x = first; x != null; x = x.next)
        {
            keyList.add(x.key);
        }

        return keyList;
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
}
