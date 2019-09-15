/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *
 */
public class MergeTwoSortedLists {

	/**
	 * @param args
	 * 
	 *             Merge two sorted linked lists and return it as a new list. The
	 *             new list should be made by splicing together the nodes of the
	 *             first two lists.
	 * 
	 *             Example:
	 * 
	 *             Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
	 */
	public static void main(String[] args) {
		MergeTwoSortedLists m = new MergeTwoSortedLists();
		System.out.println();
	}
	
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {                
        if(l1 == null && l2 ==null) {
        	return null;
        }  
        if(l1 == null) {
        	return l2;
        }
        if(l2 == null) {
        	return l1;
        }
        ListNode  node = null;
        ListNode  currentNode1= null;
        ListNode  currentNode2 = null;
        ListNode  currentNodeAux = null;
        if(l1.val > l2.val) {
        	node = new ListNode(l2.val);
        	currentNode2 = l2.next;
        	currentNode1 = l1;
        }else {
        	node = new ListNode(l1.val);
        	currentNode2 = l2;
        	currentNode1 = l1.next;
        }
        currentNodeAux = node;
        while(currentNode1!= null || currentNode2!= null) {
        	
        	if(currentNode1 == null || currentNode2 !=null && currentNode1.val > currentNode2.val  ) {
        		ListNode newNode = new ListNode(currentNode2.val);
        		currentNodeAux.next = newNode;
        		currentNodeAux = currentNodeAux.next;
        		currentNode2 = currentNode2.next;
        	}else if(currentNode2 == null || currentNode1 !=null && currentNode1.val < currentNode2.val) {
        		ListNode newNode = new ListNode(currentNode1.val);
        		currentNodeAux.next = newNode;
        		currentNodeAux = currentNodeAux.next;
        		currentNode1 = currentNode1.next;
        	}else {
        		ListNode newNode = new ListNode(currentNode1.val);
        		ListNode newNode2 = new ListNode(currentNode2.val);
        		currentNodeAux.next = newNode;
        		currentNodeAux = currentNodeAux.next;
        		currentNodeAux.next = newNode2;
        		currentNodeAux = currentNodeAux.next;        		
        		currentNode1 = currentNode1.next;
        		currentNode2 = currentNode2.next;        		
        	}
        }
        return node;
    }
    
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {                
        if(l1 == null && l2 ==null) {
        	return null;
        }  
        if(l1 == null) {
        	return l2;
        }
        if(l2 == null) {
        	return l1;
        }
        ListNode  node = new ListNode(0);
        ListNode  currentNodeAux = node;

        while(l1!= null && l2!= null) {
        	
        	if(l1.val >= l2.val  ) {
        		currentNodeAux.next = l2;
        		l2 = l2.next;
        	}else if(l1.val < l2.val) {
        		currentNodeAux.next = l1;
        		l1 = l1.next;
        	}
        	currentNodeAux =currentNodeAux.next;
        }
        
        currentNodeAux.next = l1!=null?l1:l2;
        return node.next;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { 
    	if(l1 == null && l2 == null) {
    		return null;
    	}
    	if(l1 == null) {
    		return l2;
    	}
    	if(l2 == null) {
    		return l1;
    	}
    	if(l1.val > l2.val) {
    		l2.next = mergeTwoLists(l1, l2.next);
    		return l2;
    	}else {
    		l1.next = mergeTwoLists(l1.next, l2);
    		return l1;
    	}		
    }
    
   
}
