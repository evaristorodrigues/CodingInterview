/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *19. Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndOfList {

	/**
	 * 
	 */
	public RemoveNthNodeFromEndOfList() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//two pass - have to traverse n to find the length and to traverse N -n to remove = N + (N-n)
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null) {
        	return head;
        }
        ListNode dummy= new ListNode(0);
        dummy.next = head;
        ListNode aux = head;
        int count =0;
        while(aux!=null) {
        	aux=aux.next;
        	count++;
        }
        if(count < n) {
        	return head;
        }
        count -= n;
        aux = dummy;
        while(count > 0) {
        	aux = aux.next;
        	count--;
        }
        ListNode remove = aux.next;
        aux.next = remove.next;        
        return dummy.next;
    }
    //one pass, because in the first loop is n and in the last, traverse length -n
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
        	return head;
        }
        ListNode dummy= new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        //n+1
        while(n >= 0) {
        	fast = fast.next;
        	n--;
        }
        while(fast!=null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        ListNode remove = slow.next;
        slow.next = remove.next;        
        return dummy.next;
    }

}
