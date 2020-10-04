/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author evaristosrodrigues
 *49. Group Anagrams
 */
public class GroupAnagrams {

	/**
	 * @param args
	 * Given an array of strings, group anagrams together.

  Example:

  Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
  Output:
  [
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
   ]
  Note:

  All inputs will be in lowercase.
  The order of your output does not matter.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<String>> groupAnagrams(String[] strs) {
    	if(strs == null) {
    		return new ArrayList<List<String>>();
    	}
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	for( int i =0; i < strs.length; i++) {
    		char[] chars = strs[i].toCharArray();
    		Arrays.sort(chars);
    		String ordered = String.valueOf(chars);
    		if(!map.containsKey(ordered)) {
    			map.put(ordered, new ArrayList<String>());
    		}
    		map.get(ordered).add(strs[i]);    		
    	}
    	return new ArrayList<List<String>>(map.values());
	}
    
    public List<List<String>> groupAnagrams2(String[] strs) {
    	if(strs == null) {
    		return new ArrayList<List<String>>();
    	}
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	for( int i =0; i < strs.length; i++) {
    		int[] chars = new int[27];
    		for(char c : strs[i].toCharArray()) {
    			chars[c-'a']++;
    		}
    		StringBuilder key = new StringBuilder();
    		for(int v :chars) {
    			key.append(v);
    			key.append("#");
    		}
    		
    		if(!map.containsKey(key.toString())) {
    			map.put(key.toString(), new ArrayList<String>());
    		}
    		map.get(key.toString()).add(strs[i]);    		
    	}
    	return new ArrayList<List<String>>(map.values());
	}


}
