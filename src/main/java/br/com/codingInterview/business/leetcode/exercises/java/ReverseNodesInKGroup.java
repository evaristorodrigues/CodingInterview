/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *25. Reverse Nodes in k-Group

 */
public class ReverseNodesInKGroup {

	/**
	 * 
	 */
	public ReverseNodesInKGroup() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
Accepted
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null || head.next == null || k ==0) {
    		return head;
    	}
    	int count=0;
    	ListNode aux = head;
    	while(aux!=null) {
    		aux = aux.next;
    		count++;
    	}
    	aux = head;
    	count = count/k;
    	ListNode before = null;
    	boolean change =true;
    	while(count>0) {
    		before = reverse(before, aux, k-1);
    		if(change) {
    			head = before;
    			change =false;
    		}
    		before = aux;
    		aux = aux.next;
    		count--;
    	}     
    	return head;
    }

	private ListNode reverse(ListNode before, ListNode aux, int k) {
		ListNode first = aux;
		ListNode second = aux.next;		
		while(second!= null&& k-- > 0) {
			ListNode temp = second.next;
			second.next = first;
			first = second;
			second = temp;
		}
		if(before != null) {
	    	before.next = first;
		}
		aux.next= second;
		return first;
	}

}
