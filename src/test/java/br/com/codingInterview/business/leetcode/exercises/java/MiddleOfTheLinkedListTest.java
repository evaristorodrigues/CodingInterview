package br.com.codingInterview.business.leetcode.exercises.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

public class MiddleOfTheLinkedListTest {
    public static MiddleOfTheLinkedList middleOfTheLinkedList = null;
	@BeforeClass
	public static void init() {
		middleOfTheLinkedList = new MiddleOfTheLinkedList();
	}
	@Test
	public final void testMiddleNode() {
		Integer[] array = {1,2,3,4,5,6};
		ListNode node = TransformUtil.arrayToListNode(array);
		ListNode expected = node;
		for( int i =0; i <3 ; i++) {
			expected = expected.next;
		}		
		assertEquals(expected, middleOfTheLinkedList.middleNode(node));
	}

}
