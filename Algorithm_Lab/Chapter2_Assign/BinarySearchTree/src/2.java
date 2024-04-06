//22113644 이승형
import java.util.Arrays;

class Solution 
{
    public int getListSize(ListNode head) 
    {
        int size = 0;

        for(; head != null; head = head.next)
        {
            size++;
        }
            
        return size;
    }

    public void listToArray(int[] arr, ListNode head) 
    {
        for (int i = 0; head != null; head = head.next, i++) 
        {
            arr[i] = head.val;
        }

        Arrays.sort(arr);
    }

    private TreeNode arrayToBST(int[] arr, int start, int end) 
    {
        if (start > end) 
        {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = arrayToBST(arr, start, mid - 1);
        root.right = arrayToBST(arr, mid + 1, end);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) 
    {
        int size = getListSize(head);
        int[] arr = new int[size];
        listToArray(arr, head);
        return arrayToBST(arr, 0, size - 1);
    }
}