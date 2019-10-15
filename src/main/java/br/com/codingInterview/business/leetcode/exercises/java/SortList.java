/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Evaristo 148. Sort List
 */
public class SortList {

	/**
	 * @param args Sort a linked list in O(n log n) time using constant space
	 *             complexity.
	 * 
	 *             Example 1:
	 * 
	 *             Input: 4->2->1->3 Output: 1->2->3->4 Example 2:
	 * 
	 *             Input: -1->5->3->4->0 Output: -1->0->3->4->5
	 */
	public static void main(String[] args) {
		SortList s = new SortList();
		
		ListNode head = new ListNode(4);
		ListNode a = new ListNode(2);
		head.next = a;
		ListNode b = new ListNode(1);
		a.next = b;
		ListNode c = new ListNode(3);
		b.next = c;
		
		ListNode current = s.sortList(head);
		while(current!=null) {
			System.out.println(current.val);
			current = current.next;
		}

	}
	
    public ListNode sortList2(ListNode head) {
    	if(head == null || head.next == null) {
    		return head;
    	}
        List<Integer> array = new ArrayList<Integer>();
        
        ListNode currentNode = head;
        
        while(currentNode !=null) {
        	array.add(currentNode.val);
        	currentNode = currentNode.next;        	       	
        }
        Integer[]  newArray = new Integer[array.size()];
		newArray= helperSortList( array.toArray(newArray), array.size());
		ListNode newNode = new ListNode(Integer.MIN_VALUE);
		currentNode = newNode;
		for(int i = 0; i < newArray.length; i++) {
			ListNode node = new ListNode(newArray[i]);
			currentNode.next = node;
			currentNode = currentNode.next;
		}
        return newNode.next;
    }

	private Integer[] helperSortList(Integer[] array, int size) {
		if(size <  2) {
			return array;
		}
		int mid = Math.floorDiv(size, 2);
		Integer[] left = Arrays.copyOfRange(array, 0, mid);
		Integer[] right = Arrays.copyOfRange(array, mid, size);
		
		return helperMerge(helperSortList(left, left.length),helperSortList(right, right.length) );
	}

	private Integer[] helperMerge(Integer[] left, Integer[] right) {
		
		Integer[] currentArray = new Integer[left.length+ right.length];
		Integer positionLeft =0;
		Integer positionRight =0;
		Integer positionArray = 0;
		while(positionLeft < left.length && positionRight < right.length) {
			if(left[positionLeft] <= right[positionRight]) {
				currentArray[positionArray++] =left[positionLeft++];
			}else {
				currentArray[positionArray++] =right[positionRight++];
			}
		}		
		while(positionLeft < left.length ) {
			currentArray[positionArray++] =left[positionLeft++];
		}
		while(positionRight < right.length ) {
			currentArray[positionArray++] =right[positionRight++];
		}	
		return currentArray;
	}
	
    public ListNode sortList(ListNode head) {
    	if(head == null || head.next == null) {
    		return head;
    	}    	
    	ListNode slow = head;
    	ListNode fast = head.next;
        while(fast!=null && fast.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        
    	return mergeSort(sortList(left),sortList(right));
    }

	private ListNode mergeSort(ListNode left, ListNode right) {
		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode current = head;
		
		while(left != null && right != null) {
			if(left.val <= right.val) {
				current.next = left;
				current = current.next;
				left = left.next;				
			}else {
				current.next = right;
				current = current.next;
				right = right.next;
			}
		}
		
		while(left !=null) {
			current.next = left;
			current = current.next;
			left = left.next;
		}
		
		while(right !=null) {
			current.next = right;
			current = current.next;
			right = right.next;
		}
		return head.next;
	}
	
	
	 public ListNode sortList3(ListNode head) {
	    	if(head == null || head.next == null) {
	    		return head;
	    	}    	
	    	ListNode current = head;    	
	    	ListNode left = new ListNode(Integer.MIN_VALUE);
	    	ListNode leftCurrent = left;    	
	    	ListNode right = new ListNode(Integer.MIN_VALUE);
	    	ListNode rightCurrent = right;
	    	//TODO rever o while
	    	while(current!= null) {
	    		leftCurrent.next = current;
	    		rightCurrent.next = current.next;    		
	    		leftCurrent = leftCurrent.next;
	    	    rightCurrent = rightCurrent.next;
	    	    if(current.next != null) {
	    	    	current = current.next.next; 	    	
	    	    }else {
	    	    	current = current.next;
	    	    }
	    		
	    	}
	    	leftCurrent.next = null;
	    	
	    	return mergeSort3(sortList3(left.next),sortList3(right.next));
	    }

		private ListNode mergeSort3(ListNode left, ListNode right) {
			ListNode head = new ListNode(Integer.MIN_VALUE);
			ListNode current = head;
			
			while(left != null && right != null) {
				if(left.val <= right.val) {
					current.next = left;
					current = current.next;
					left = left.next;				
				}else {
					current.next = right;
					current = current.next;
					right = right.next;
				}
			}
			
			while(left !=null) {
				current.next = left;
				current = current.next;
				left = left.next;
			}
			
			while(right !=null) {
				current.next = right;
				current = current.next;
				right = right.next;
			}
			return head.next;
		}

}
