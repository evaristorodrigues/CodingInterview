/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Evaristo
 *
 */
public class RotateListTest {
	private static RotateList rotateList =null; 
	@BeforeClass
	public static void init() {
		rotateList = new RotateList();
	}
	@Test
	public final void test() {
		Integer[] expecteds = {4,5,1,2,3};
		Integer[] array = {1,2,3,4,5};
		ListNode actuals = TransformUtil.arrayToListNode(array);
		
		assertEquals(expecteds, TransformUtil.listNodeToArray(rotateList.rotateRight(actuals,2)));
	}

}
