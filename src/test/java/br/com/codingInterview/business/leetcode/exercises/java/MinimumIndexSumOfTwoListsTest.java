/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Evaristo
 *
 */
public class MinimumIndexSumOfTwoListsTest {

	public static MinimumIndexSumOfTwoLists minimumIndexSumOfTwoLists;
	
	@BeforeClass
	public static  void init() {
		minimumIndexSumOfTwoLists = new MinimumIndexSumOfTwoLists();
	}
	
	@Test
	public  void test() {
		String[] a = {"Shogun","KFC", "Tapioca Express", "Burger King"};
		String[] b = {"KFC", "tt","Shogun", "Burger King"};
		assertArrayEquals(new String[] {"KFC"}, minimumIndexSumOfTwoLists.findRestaurant(a, b));	
	}

}
