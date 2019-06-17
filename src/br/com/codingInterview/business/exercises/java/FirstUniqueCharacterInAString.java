/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Evaristo
 *387. First Unique Character in a String
 */
public class FirstUniqueCharacterInAString {

	/**
	 * @param args
	 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
	 */
	public static void main(String[] args) {
		FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
		String s = "ababh";
		System.out.println(f.firstUniqChar(s));

	}
	
    public int firstUniqChar3(String s) {
    	if(s== null || s.length() ==0) {
    		return -1;
    	}
        Map<Character,Integer> values = new HashMap<>();        
        List<Character>  occor = new ArrayList<>();
        
        for(int i =0; i < s.length(); i ++) {
        	if(values.containsKey(s.charAt(i))) {
        		occor.remove(new Character(s.charAt(i)));
        	}else {
        		values.put(s.charAt(i), i);
        		occor.add(s.charAt(i));
        	}
        }
        if(occor.size() ==0) {
        	return -1;
        }
        
        return values.get(occor.get(0));
    }
    
    public int firstUniqChar2(String s) {
    	if(s== null || s.length() ==0) {
    		return -1;
    	}
        Map<Character,Integer> values = new HashMap<>();        
        for(int i =0; i < s.length(); i ++) {
        	if(values.containsKey(s.charAt(i))) {
        		values.put(s.charAt(i), values.getOrDefault(s.charAt(i), 0)+1);
        	}else {
        		values.put(s.charAt(i), 1);        		
        	}
        }
       for(int i=0; i < s.length(); i++) {
        	if(values.get(s.charAt(i))==1) {
        		return i;
        	}
        }
        return -1;
    }
    
    public int firstUniqChar(String s) {
    	if(s== null || s.length() ==0) {
    		return -1;
    	}
       char[] values = new char[26];   
        for(int i =0; i < s.length(); i ++) {
               values[s.charAt(i) - 'a']++;
        }
       for(int i=0; i < s.length(); i++) {
        	if(values[s.charAt(i) - 'a'] ==1) {
        		return i;
        	}
        }
        return -1;
    }

}
