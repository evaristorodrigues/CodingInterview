/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *2. Add Two Numbers
 */
public class AddTwoNumbers {

	/**
	 * 
	 */
	public AddTwoNumbers() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AddTwoNumbers atn = new AddTwoNumbers();
		int[] array1 = {2,9};
		int[] array2 = {2,1};
		TransformUtil.listNodeToString(atn.addTwoNumbers(TransformUtil.arrayToListNode(array1),TransformUtil.arrayToListNode(array2)));

	}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     if(l1== null)return l2;
     if(l2==null)return l1;
     ListNode list = new ListNode(0);
     ListNode current = list;
     boolean goOne = false;
     while(l1!= null || l2!= null) {
    	 int value =0;
    	 if(l1!=null) {
    		 value+= l1.val;
    		 l1 = l1.next;
    	 }
    	 if(l2!=null) {
    		 value+= l2.val;
    		 l2 = l2.next;
    	 }
    	 if(goOne) {
    		 value+=1;
    	 }
    	 
    	 if(value>9) {
    		 value-=10;
    		 goOne = true;
    	 }else {
    		 goOne = false;
    	 }
    	 
    	 current.next = new ListNode(value);
    	 current = current.next;
     }
     if(goOne) {
    	 current.next = new ListNode(1);
     }
     
     return list.next;
    }
}
