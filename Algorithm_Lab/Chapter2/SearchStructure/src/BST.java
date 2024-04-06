import java.util.ArrayList;

class Node<K, V>
{
    K key;
    V value;
    Node<K, V> left, right;
    
    int N; //자손 노드 + 1(ordered 연산)
    int aux; //AVL이나 RB트리에 사용
    Node<K, V> parent; //AVL or RB

    public Node(K key, V val)
    {
        this.key = key;
        this.value = val;
        this.N = 1;
    }

    public int getAux()
    {
        return aux;
    }

    public void setAux(int value)
    {
        aux = value;
    }
}

public class BST<K extends Comparable<K>, V>
{
    protected Node<K, V> root;
    
    protected Node<K, V> treeSearch(K key) //modified search, 키를 입력받아, 그 키를 갖는 노드 또는 순회의 마지막 노드를 반환
    { //비교 횟수 = 노드의 레벨(root = 1)
        Node<K, V> x = root; //BST에 대한 모든 연산은 root부터 시작

        while(true)
        {
            int cmp = key.compareTo(x.key);

            if(cmp == 0)
            {
                return x; //찾았으면 순회 종료
            }
            else if(cmp < 0) //x.key 보다 작을 경우, 왼쪽으로
            {
                if(x.left == null)
                {
                    return x; //없으면 순회 종료
                }
                else
                {
                    x = x.left; //왼쪽으로
                }
            }
            else
            {
                if(x.right == null) //x.key 보다 클 경우,
                {
                    return x; //없으면 순회 종료
                }
                else
                {
                    x = x.right; //오른쪽으로
                }
            }
        }
    }

    public V get(K key) //주어진 키에 해당하는 값을 반환, 키가 없으면 null
    {
        if(root == null)
        {
            return null;
        }

        Node<K, V> x = treeSearch(key);

        if(key.equals(x.key))
        {
            return x.value;
        }
        else
        {
            return null;
        }
    }

    public void put(K key, V val) //검색 후 키가 있으면 reset, 없으면 추가
    {
        if(root == null)
        {
            root = new Node<K, V>(key, val);
            return;
        }

        Node<K, V> x = treeSearch(key);
        int cmp= key.compareTo(x.key);

        if(cmp== 0)
        {
            x.value = val; //키가 존재하므로 값을 reset
        }
        else //없는 키: 새로운 노드를 생성하여 x의 자식으로 추가
        {
            Node<K, V> newNode = new Node<K, V>(key, val);

            if(cmp < 0)
            {
                x.left = newNode;
            }
            else
            {
                x.right = newNode;
            }

            newNode.parent = x;
            rebalanceInsert(newNode); //Insert의 후속 조치
        }

    }

    //BST의 subclass인 AVLTree나 RBTree에서 Overriding
    //BST에서는 신규 노드들의 모든 조상노드들의 size 증가
    protected void rebalanceInsert(Node<K, V> x)
    {
        resetSize(x.parent, 1); //root까지 조상 노드들의 size를 1 증가
    }

    protected void rebalanceDelete(Node<K, V> p, Node<K, V> deleted)
    {
        resetSize(p, -1); //root까지 조상 노드들의 size를 1 감소
    }

    private void resetSize(Node<K, V> x, int value)
    {
        for(; x != null; x = x.parent)
        {
            x.N += value;
        }
    }

    public Iterable<K> keys() //키의 정렬된 리스트를 반환 -> inorder 순회 이용
    {
        if(root == null)
        {
            return null;
        }

        ArrayList<K> keyList = new ArrayList<K>(size());
        inorder(root, keyList);
        
        return keyList;
    }

    private void inorder(Node<K, V> x, ArrayList<K> keyList)
    {
        if(x != null)
        {
            inorder(x.left, keyList);
            keyList.add(x.key);
            inorder(x.right, keyList);
        }
    }

    public void delete(K key)
    {
        if(root == null)
        {
            return; 
        }

        Node<K, V> x, y, p;
        x = treeSearch(key);

        //key가 없는 경우
        if(!key.equals(x.key))
        {
            return;
        }

        //루트이거나 자식이 두개인 노드
        if(x == root || isTwoNode(x))
        {
            if(isLeaf(x)) //루트가 리프
            {
                root = null;
                return;
            }
            else if(!isTwoNode(x))
            {
                root = (x.right == null) ? x.left : x.right; //자식을 루트로
                root.parent = null;
                return;            
            }            
            else //자식이 둘인 노드(루트 포함)
            {
                y = min(x.right); //inorder successor
                x.key = y.key; //y를 x에 복사
                x.value = y.value; //y를 x에 복사
                p = y.parent; 
                relink(p, y.right, y == p.left); //y의 자식을 p의 자식으로(y 삭제)
                rebalanceDelete(p, y); //y의 조상 노드들의 size 감소
            }
        }
        else //자식이 <= 1 이고, 루트 아님
        {
            p = x.parent;

            if(x.right == null)
            {
                relink(p, x.left, x == p.left);
            }
            else if(x.left == null)
            {
                relink(p, x.right, x == p.left);
            }

            rebalanceDelete(p, x);
        }
    }

    public boolean contains(K key)
    {
        return get(key) != null;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    protected boolean isLeaf(Node<K, V> x)
    {
        return x.left == null && x.right == null;
    }

    protected boolean isTwoNode(Node<K, V> x)
    {
        return x.left != null && x.right != null;
    }

    protected void relink(Node<K, V> parent, Node<K, V> child, boolean makeLeft)
    {
        if(child != null)
        {
            child.parent = parent; //child를 parent의 자식으로
        }

        if(makeLeft)
        {
            parent.left = child; //왼쪽 자식, 또는
        }
        else
        {
            parent.right = child; //오른쪽 자식
        }
    }

    protected void rotate(Node<K, V> x) //LL과 RR을 하나의 함수로. c->x->y가 문제
    {
        Node<K, V> y = x.parent;
        Node<K, V> z = y.parent;

        if(z == null)
        {
            root = x;
            x.parent = null;            
        }
        else
        {
            relink(z, x, y == z.left); //x를 z의 자식으로. 즉, x가 c와 y의 부모
        }

        if(x == y.left)
        {
            relink(y, x.right, true);
            relink(x, y, false); //LL            
        }
        else
        {
            relink(y, x.left, false);
            relink(x, y, true); //RR
        }
    }

        protected Node <K, V> restructure(Node<K, V> x) //x->y->z가 문제
        {
            Node<K,V> y = x.parent;
            Node<K,V> z = y.parent;

            if((x == y.left) == (y == z.left))
            {
                rotate(y);
                return y; //LL or RR : y가 중간값
            }
            else
            {
                rotate(x);
                rotate(x);
                return x; //중간값이 x:LR/RL -> LL/RR로 일단 변경
            }
        }

    protected Node<K, V> min(Node<K, V> x)
    {
        while(x.left != null)
        {
            x = x.left;            
        }

        return x;
    }

    public K min() //제일 작은 키를 반환
    {
        if(root == null)
        {
            return null;
        }

        Node<K, V> x = root;

        while(x.left != null) //제일 왼쪽에 있는 노드
        {
            x = x.left;
        }

        return x.key;
    }

    public K max() //제일 큰 키를 반환
    {
        if(root == null)
        {
            return null;
        }

        Node<K, V> x = root;

        while(x.right != null) //제일 오른쪽에 있는 노드
        {
            x = x.right;
        }

        return x.key;
    }

    public K floor(K key) //key보다 작거나 같은 키들 중에서 제일 큰 키
    {
        if(root == null || key == null)
        {
            return null;
        }

        Node<K, V> x = floor(root, key);

        if(x == null)
        {
            return null;
        }
        else
        {
            return x.key;
        }
    }

    private Node<K, V> floor(Node<K, V> x, K key)
    {
        if(x == null)
        {
            return null;
        }

        int cmp = key.compareTo(x.key);
        
        if(cmp == 0)
        {
            return x; //key와 동일한 키를 가진 노드
        }

        if(cmp < 0)
        {
            return floor(x.left, key); //key보다 크다면 계속 왼쪽으로
        }

        Node<K, V> t = floor(x.right, key); //key가 클 경우, 오른쪽으로

        //오른쪽으로 갈때는 기억해야한다, 왼쪽은 기억할 필요없다

        if(t != null)
        {
            return t; //오른쪽에 작은 키가 있을 경우
        }
        else
        {
            return x; //오른쪽에 작은 키가 없을 경우
        }
    }

    public int rank(K key) //key 보다 작은 키 수
    {
        if(root == null || key == null)
        {
            return 0;
        }

        Node<K, V> x = root;
        int num = 0;

        while(x != null) //루트부터 비교하며 key보다 작은 키의 수를 합산
        {
            int cmp = key.compareTo(x.key);

            if(cmp < 0)
            {
                x = x.left;
            }
            else if(cmp > 0) //key보다 작은 키를 갖는 노드를 발견
            {
                num += 1 + size(x.left); //왼쪽 subtree의 노드수를 합산
                x = x.right; //오른쪽 subtree도 계속 검사
            }
            else //key 값을 갖는 노드: 왼쪽 subtree만 합산
            {
                num += size(x.left);
                break;
            }
        }

        return num;
    }        

    public K select(int rank) //rank 등수에 해당하는 키를 반환
    {
        if(root == null || rank < 0 || rank >= size())
        {
            return null;
        }

        Node<K, V> x = root;

        while(true)
        {
            int t = size(x.left);

            if(rank < t) //왼쪽 subtree의 노드 수가 rank 보다 크면
            {
                x = x.left; //rank 등수의 키는 당연히 왼쪽 subtree에 있겠지
            }
            else if(rank > t) //rank 가 왼쪽 subtree의 노드 수 밖이면
            {
                rank = rank - t - 1; //왼쪽 subtree와 부모 노드는 결과에서 제외하고
                x = x.right; //오른쪽 subtree를 조사하자
            }
            else //왼쪽 subtree의 수와 rank가 일치하면
            {
                return x.key; //부모 노드의 키를 반환(rank의 시작은 0)
            }
        }
    }

    public int size()
    {
        return (root != null) ? root.N : 0;
    }
    
    private int size(Node<K, V> x)
    {
        return (x != null) ? x.N : 0;
    }
}
