package br.com.codingInterview.business.leetcode.exercises.java;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class ReverseNodesInKGroupTest {
	public static ReverseNodesInKGroup reverseNodesInKGroup = null;
	@BeforeClass
	public static void init() {
		reverseNodesInKGroup = new ReverseNodesInKGroup();
	}
	@Test
	public final void testReverseKGroup() {
		Integer[] array = {1,2,3,4,5};
		Integer[] array1 = {3,2,1,4,5};
		ListNode actual = TransformUtil.arrayToListNode(array);
		ListNode expected = TransformUtil.arrayToListNode(array1);
		actual= reverseNodesInKGroup.reverseKGroup(actual,3);
		while(expected!=null) {			
			assertEquals( expected.val, actual.val);
			expected = expected.next;
			actual = actual.next;
		}
		
		
		
	}

}
