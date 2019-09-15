/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author Evaristo 451. Sort Characters By Frequency
 */
public class SortCharactersByFrequency {

	/**
	 * @param args Given a string, sort it in decreasing order based on the
	 *             frequency of characters.
	 * 
	 *             Example 1:
	 * 
	 *             Input: "tree"
	 * 
	 *             Output: "eert"
	 * 
	 *             Explanation: 'e' appears twice while 'r' and 't' both appear
	 *             once. So 'e' must appear before both 'r' and 't'. Therefore
	 *             "eetr" is also a valid answer. Example 2:
	 * 
	 *             Input: "cccaaa"
	 * 
	 *             Output: "cccaaa"
	 * 
	 *             Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is
	 *             also a valid answer. Note that "cacaca" is incorrect, as the same
	 *             characters must be together. Example 3:
	 * 
	 *             Input: "Aabb"
	 * 
	 *             Output: "bbAa"
	 * 
	 *             Explanation: "bbaA" is also a valid answer, but "Aabb" is
	 *             incorrect. Note that 'A' and 'a' are treated as two different
	 *             characters.
	 */
	public static void main(String[] args) {
		SortCharactersByFrequency s = new SortCharactersByFrequency();
		String value = "2a554442f544asfasssffffasss";
		System.out.println(s.frequencySort(value));
	}


	public String frequencySort2(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}		
		char[] values = new char[128];
		for (int i = 0; i < s.length(); i++) {
				values[s.charAt(i)]++;
		}
		StringBuilder result = new StringBuilder();;
		while(result.length()< s.length()) {
			int max = 0;
			for(int i=1; i < values.length; i++) {
				if( values[max] < values[i]) {
					max = i;
				}
			}
			for(int i=values[max]; i > 0; i--) {
				result.append((char)max);
			}
			values[max]=0;
		}		
		return result.toString();
	}

	
	public String frequencySort1(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}		
		Map<Character, Integer> values = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			values.put(s.charAt(i), values.getOrDefault(s.charAt(i), 0) + 1);
		
		}
		 List<Map.Entry<Character, Integer>> entries = new ArrayList<>(values.entrySet());
		 
		 Collections.sort(entries, new Comparator<Map.Entry<Character, Integer>>() {
		        @Override
		        public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
		            return b.getValue() - a.getValue();
		        }
		    });
		    
		StringBuilder result = new StringBuilder();
		
		for(Map.Entry<Character, Integer> entry:entries) {
			for(int i = entry.getValue() ;i >0; i--) {
				result.append(entry.getKey());
			}
		}
		
		return result.toString();
	}	
	
	
	public String frequencySort(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}			
		Map<Character, Integer> values = new HashMap<Character, Integer>();
		
		for(char value:s.toCharArray()) {
			values.put(value, values.getOrDefault(value, 0)+1);
		}
		PriorityQueue<Map.Entry<Character, Integer>> entries = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
				return b.getValue() - a.getValue();
			}
			
		});
        entries.addAll(values.entrySet());
        StringBuilder result = new StringBuilder();
        while (!entries.isEmpty()) {
        	Map.Entry<Character, Integer> entry = entries.poll();
			for(int i = entry.getValue(); i > 0; i--) {
				result.append(entry.getKey());
			}
		}
        
        return result.toString();
		
	}
	

	
}
