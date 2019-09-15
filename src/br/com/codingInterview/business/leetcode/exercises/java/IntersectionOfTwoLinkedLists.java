/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *
 */
public class IntersectionOfTwoLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists itl = new IntersectionOfTwoLinkedLists();
		
	    ListNode a = TransformUtil.arrayToListNode(new Integer[] {1});
	    ListNode b = TransformUtil.arrayToListNode(new Integer[] {0});
	    ListNode i = TransformUtil.arrayToListNode(new Integer[] {2,3});
	   // a.next=i;
	    b.next=i;	    
         
	    TransformUtil.listNodeToString(itl.getIntersectionNode(a, b));

	}
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	
         int a =0;
         int b =0;
         ListNode la= headA;
         ListNode lb = headB;
         
         while(la!=null) {
        	 a++;
        	 la = la.next;
         }
         while(lb!=null) {
        	 b++;
        	 lb = lb.next;
         }
         
         int max = Math.min(a, b);
         
         while(a > max) {
        	 headA = headA.next;
        	 a--;
         }
         while(b > max) {
        	 headB = headB.next;
        	 b--;
         }
         
        while(headA != headB) {

               headA = headA.next;
               headB = headB.next;
         }

        return headA;
    }
    
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //boundary check
    	
    
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
        	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }
        
        return a;
    }

}
