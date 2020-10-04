package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindAllAnagramsInAStringTest {
	public static  FindAllAnagramsInAString f = null;

	@BeforeClass
	public static void init() {
		 f = new FindAllAnagramsInAString();
	}
	@Test
	public void testFindAnagrams() {
		
		List<Integer> expecteds = Arrays.asList(0,1,2);
		List<Integer> actuals = f.findAnagrams("abba", "ab");
		Assert.assertEquals(expecteds, actuals);
		
		
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		m.put(1, 1);
		Map.Entry[][] v = m.entrySet().toArray(new Map.Entry[m.size()][2]);
		System.out.println(v[0]+"-"+ v[1]);
		
	}

}
