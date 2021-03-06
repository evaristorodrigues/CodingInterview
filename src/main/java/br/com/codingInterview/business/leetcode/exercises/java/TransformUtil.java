/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.List;

import br.com.codingInterview.business.leetcode.exercises.java.ListNode;

/**
 * @author Evaristo
 *
 */
public class TransformUtil {
	
	public static ListNode arrayToListNode(Integer[] array) {
		if(array == null || array.length ==0) {
			return null;
		}
		ListNode head = new ListNode(array[0]);
		ListNode current = head;
		for(int i=1; i < array.length; i++) {
			current.next = new ListNode(array[i]);
			current = current.next;
		}
		
		return head;
	}
	
	public static void listNodeToString(ListNode node) {
		while(node !=null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	public static ListNode arrayToListNode(int[] array) {
		if(array == null || array.length ==0) {
			return null;
		}
		ListNode head = new ListNode(array[0]);
		ListNode current = head;
		for(int i=1; i < array.length; i++) {
			current.next = new ListNode(array[i]);
			current = current.next;
		}
		
		return head;
	}

	public static Integer[] listNodeToArray(ListNode node) {
        List<Integer> array = new ArrayList<Integer>();
		while(node != null) {
			array.add(node.val);
			node = node.next;
		}
		return array.toArray(new Integer[array.size()]);
	}

}
