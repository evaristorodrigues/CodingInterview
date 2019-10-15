/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Evaristo
 *
 */
public class TrappingRainWaterTest {

	/**
	 * Test method for {@link br.com.codingInterview.business.leetcode.exercises.java.TrappingRainWater#trap(int[])}.
	 */
	public static TrappingRainWater trappingRainWater;
	@BeforeClass
	public static void initTrappingRainWater() {
		trappingRainWater = new TrappingRainWater();
	}
	@Test
	public final void validateNull() {
	  int[] height = null;
	  int result = trappingRainWater.trap(height);
	  assertEquals(0, result); 
	}
	@Test
	public final void validateQuantityElements() {
	  int[] height = {};
	  int result = trappingRainWater.trap(height);
	  assertEquals(0, result);
	}
	@Test
	public final void testTrap() {
       int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
	   int result = trappingRainWater.trap(height);
       assertEquals(6, result);       
	}

}
