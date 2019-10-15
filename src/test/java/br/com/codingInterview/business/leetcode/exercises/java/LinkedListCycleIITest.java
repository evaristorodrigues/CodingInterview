package br.com.codingInterview.business.leetcode.exercises.java;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class LinkedListCycleIITest {
	public static LinkedListCycleII linkedListCycleII = null;
		// TODO Auto-generated constructor stub
	@BeforeClass
	public static void init() {
		linkedListCycleII = new LinkedListCycleII();
	}

	@Test
	public final void testDetectCycle() {
		Integer[] array = {3,2,0,-4};
		ListNode actual = TransformUtil.arrayToListNode(array);
		ListNode expected = actual.next.next;
		ListNode aux = actual;
		while(aux!=null && aux.next!=null) {
			aux = aux.next;
		}
		aux.next = actual.next.next;
		assertEquals(expected, linkedListCycleII.detectCycle(actual));
	}
}
