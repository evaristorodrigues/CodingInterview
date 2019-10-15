/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *142. Linked List Cycle II
 */
public class LinkedListCycleII {

	/**
	 * 
	 */
	public LinkedListCycleII() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    public ListNode detectCycle(ListNode head) {
    	if(head== null || head.next == null) {
    		return null;
    	}
    	ListNode slow = head;
    	ListNode fast = head;    	
    	while(fast!=null && fast.next!=null) {
    		fast = fast.next.next;
    		slow = slow.next;
    		//found cicle
    		if(slow == fast) {
    			while(head!=fast) {
    				head = head.next;
    				fast = fast.next;
    			}    			
    			return head;
    		}
    	}       	
     return null;        
    }
}
