/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo
 *24. Swap Nodes in Pairs
 */
public class SwapNodesInPairs {

	/**
	 * @param args
	 * Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
	 */
	public static void main(String[] args) {
		SwapNodesInPairs sw = new SwapNodesInPairs();
        TransformUtil.listNodeToString(
        		sw.swapPairs(
        				TransformUtil.arrayToListNode(new Integer[] {1,2,3,4,5,6,7,8})));
	}
	
    public ListNode swapPairs2(ListNode head) {
      if(head ==null || head.next == null) {
    	  return head;
      }
      ListNode current = head;
      ListNode second = new ListNode(0);
      head = second;
      
      while(current!=null && current.next!= null) {
          ListNode temp = current.next;//2->3
          current.next = temp.next;////1->3
          temp.next =current;//2->1->3
    	  second.next =temp;//2->2->1->3->4->5->6..
    	  second = second.next.next;//1->3->4->5->6
    	  current = current.next;//3
      }
      head = head.next;
    	return head;
    }
    
    public ListNode swapPairs(ListNode head) {
        if(head ==null || head.next == null) {
      	  return head;
        }
        //Create the first and the second
        ListNode first = head;
        ListNode second = head.next;
        
        //change positions
        first.next = second.next;
        second.next = first;
        head = second;
        
        //recursively change the next 2 positions
        first.next=swapPairs( first.next);

      	return head;
      }


}
