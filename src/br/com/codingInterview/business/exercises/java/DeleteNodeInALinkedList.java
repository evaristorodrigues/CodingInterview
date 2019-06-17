package br.com.codingInterview.business.exercises.java;

public class DeleteNodeInALinkedList {

	/** 
	 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:



 

Example 1:

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
Example 2:

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
*/
	public static void main(String[] args) {
		DeleteNodeInALinkedList d = new DeleteNodeInALinkedList();
		
		ListNode head = new ListNode(4);
		ListNode a = new ListNode(5);
		head.next =a;
		ListNode b = new ListNode(1);
		a.next =b;
		ListNode c = new ListNode(9);
		b.next = c;

		
		d.deleteNode(head);
		ListNode current = head;
		while(current!=null) {
			System.out.println(current.val);
			current = current.next;
		}
	}
	
    public void deleteNode2(ListNode node) {    	
    	ListNode current = node;
    	ListNode previous = null;
    	int value = 0;
    	while(current!=null) {
    		System.out.println(current.val);
    		if(value == current.val && current.next!= null) {
    			if(previous!=null) {
    				previous.next = current.next;    				
    			}else {
    				node = current.next;
    			}
    		}
    		current = current.next;
    		previous = current;    		
    	}        
    }
    
    public void deleteNode3(ListNode node) {    	
       ListNode current = node;
        
        while(current!=null) {
           ListNode nextNode = current.next;
           if(nextNode!=null) {
	           current.val = nextNode.val;
	           current.next= nextNode.next;
           }else {
        	   current.next = null;
           }
           current = nextNode;
        }
        
        
    }
    
    public void deleteNode(ListNode node) {    	
        if(node.next!=null) {
	    	node.val = node.next.val;
	    	node.next = node.next.next;
        }      
    }

}
