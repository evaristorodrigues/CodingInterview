package br.com.codingInterview.business.leetcode.exercises.java;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class RemoveNthNodeFromEndOfListTest {
    public static RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = null;
	@BeforeClass
	public static void init() {
		removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
	}
	@Test
	public final void testRemoveNthFromEnd() {
		Integer[] array = {1,2,3,4,5};
		Integer[] array2 = {1,2,3,5};
		ListNode node = TransformUtil.arrayToListNode(array);
		ListNode node2 = TransformUtil.arrayToListNode(array2);
		node = removeNthNodeFromEndOfList.removeNthFromEnd(node, 2);
		while(node2!=null) {
			assertEquals(node.val, node2.val);
			node = node.next;
			node2 = node2.next;
		}
		
	}

}
