//22113644 이승형
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main 
{
    static class Node 
    {
        int data;
        Node left, right;

        public Node(int data) 
        {
            this.data = data;
        }
    }

    static class BinarySearchTree 
    {
        Node root;

        BinarySearchTree() 
        {
            root = null;
        }

        void insert(int data) 
        {
            root = insertRec(root, data);
        }

        Node insertRec(Node root, int data) 
        {
            if (root == null) 
            {
                root = new Node(data);
                return root;
            }

            if (data < root.data) 
            {
                root.left = insertRec(root.left, data);
            } 
            else if (data > root.data) 
            {
                root.right = insertRec(root.right, data);
            }

            return root;
        }

        void buildTree(int[] preorder) 
        {
            for (int data : preorder) 
            {
                root = insertRec(root, data);
            }
        }

        void printTree(Node node) 
        {
            if (node == null) 
            {
                return;
            }

            printTree(node.left);
            printTree(node.right);
            System.out.print(node.data + " ");
        }        
    }

    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree tree = new BinarySearchTree();
        String input;
        StringBuilder sb = new StringBuilder();

        while (true) 
        {
            input = br.readLine();
            if (input == null || input.equals(""))
            {
                break;
            }                    
            sb.append(input).append(" ");
        }

        String[] strArr = sb.toString().trim().split(" ");
        int[] preorder = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) 
        {
            preorder[i] = Integer.parseInt(strArr[i]);
        }

        tree.buildTree(preorder);

        tree.printTree(tree.root);
    }
}