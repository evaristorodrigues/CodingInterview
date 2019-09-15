/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *206. Reverse Linked List
 */
public class ReverseLinkedList {

	/**
	 * @param args
	 * 
	 * Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?



 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
                                                          
	 */
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		ListNode second= new ListNode(2);
		head.next = second;
		ListNode third =new ListNode(3);
		second.next =third;
		ListNode forth = new ListNode(4);
		third.next =forth;
		
		ReverseLinkedList r = new ReverseLinkedList();
		ListNode l= r.reverseList3(head);
		
		while(l!=null) {
			System.out.println(l.val);
			l = l.next;
		}

	}
	/**  First -> Second  -> temp*/
	
	 public ListNode reverseList(ListNode head) {
	    	if(head == null) {
	    		return head;
	    	}
	    	ListNode first = head;
	    	ListNode second = head.next;
	    	ListNode current = first;
	    	current.next = null;
	    	
	    	while(current != null && second!=null) {
	    		ListNode temp = second.next;
	    		second.next = current;    	 
	    		current = temp;
	    		if(current!= null) {
	    			ListNode temp2 = temp.next;
	    			current.next = second;
	    			second = temp2;    			
	    		}
	    	}  	
	    	
	    	return second == null? current:second;
	    }
	 
	 public ListNode reverseList2(ListNode head) {
	    	if(head == null  || head.next == null) {
	    		return head;
	    	}	    	
	    	ListNode temp = head.next;
	    	head.next = null;
	     	return helperReverseList(head, temp);
	    }
	private ListNode helperReverseList(ListNode head, ListNode next) {
    	if(head == null  || next == null) {
    		return head;
    	}
    	ListNode first = head;
    	ListNode second = next;
    	ListNode temp = next.next;
    	
        second.next = first;          	
    	
		return helperReverseList(second, temp);
	}
	
	 public ListNode reverseList3(ListNode head) {
	    	if(head == null  || head.next == null) {
	    		return head;
	    	}	    	
	    	ListNode temp = head.next;
	    	head.next = null;
	     	return helperReverseList2(head, temp);
	    }
	private ListNode helperReverseList2(ListNode head, ListNode next) {
 	if(head == null  || next == null) {
 		return head;
 	}
 	ListNode first = head;
 	ListNode second = next;
 	ListNode temp = next.next;
 	
    second.next = first; 
    if(temp!= null) {    	
    	ListNode temp2 = temp.next;
    	temp.next = second;
    	return helperReverseList2(temp, temp2);
    }else {
    	return helperReverseList2(second, temp);
    } 	
		
	}

}
