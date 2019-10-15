/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *234. Palindrome Linked List
 */
public class PalindromeLinkedList {

	/**
	 * @param args
	 * Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
	 */
	public static void main(String[] args) {
		PalindromeLinkedList p = new PalindromeLinkedList();
		Integer[] a = {};
		System.out.println(p.isPalindrome(TransformUtil.arrayToListNode(a)));
	}
	
    public boolean isPalindrome(ListNode head) {
     ListNode slow = head, fast = head;
     ListNode leftReverse = null;
     while(fast!= null && fast.next!= null) {
    	 fast = fast.next.next;
    	 ListNode temp = slow.next;
    	 slow.next = leftReverse;
    	 leftReverse = slow;
    	 slow = temp;
     }
     ListNode right = slow;
     if(fast!=null) {
    	 right = slow.next;
     }
     
     while(right!=null) {
    	 if(right.val != leftReverse.val) {
    		 return false;
    	 }
    	 right = right.next;
    	 leftReverse = leftReverse.next;
     }
     
     return true;
    }

}
