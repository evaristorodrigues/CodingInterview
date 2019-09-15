/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 * 
 * 203. Remove Linked List Elements
 *
 */
public class RemoveLinkedListElements {

	/**
	 * Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
	 */
	public static void main(String[] args) {
		RemoveLinkedListElements r = new RemoveLinkedListElements();
		
		ListNode head = new ListNode(4);
		ListNode ai = new ListNode(4);
		head.next = ai;
		ListNode a = new ListNode(5);
		ai.next =a;
		ListNode b = new ListNode(5);
		a.next =b;
		ListNode c = new ListNode(9);
		b.next = c;

		
		head = r.removeElements(head,91);
		ListNode current = head;
		while(current!=null) {
			System.out.println(current.val);
			current = current.next;
		}

	}
	//parei remover o primeiro
    public ListNode removeElements(ListNode head, int val) {
    	ListNode current = head;
    	ListNode previous = null;    	
    	while(current!=null) {
    		if(val == current.val) {
    			if(previous!=null) {
    				previous.next = current.next;   
    				current =current.next;
    			}else {
    				if(current.next!=null) {
    					current.val = current.next.val;
    					current.next = current.next.next;    					
    				}else {
    					return null;
    				}
    			}
    		}else {
    		previous = current;
    		current = current.next;
    		}		
    	}
    	return head;
    }

}
