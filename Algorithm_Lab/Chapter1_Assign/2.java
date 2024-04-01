//22113644 이승형
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode insertionSortList(ListNode head) 
    {
        ListNode temp = new ListNode(0);
	    ListNode prev = temp;
	    ListNode curr = head;

	    while (curr != null)
	    {
	        ListNode next = curr.next;
            while (prev.next != null && prev.next.val < curr.val)
            {
                prev = prev.next;
            }

            curr.next = prev.next;
            prev.next = curr;
            prev = temp;
            curr =next;            
	    }

	    return temp.next;
    }
}