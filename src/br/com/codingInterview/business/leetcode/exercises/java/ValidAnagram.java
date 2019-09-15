/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Evaristo
 *242. Valid Anagram
 */
public class ValidAnagram {

	/**
	 * @param args
	 * 
	 * Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
	 */
	public static void main(String[] args) {
		ValidAnagram v = new ValidAnagram();
		System.out.println(v.isAnagram("anagram","nagaram"));
       
	}

    
    public boolean isAnagram6(String s, String t) { 
    	if(s.length() != t.length() || s== null || t== null) {
    		return false;
    	}       
        return ordenaString(s, t) ;
    }
	private boolean ordenaString(String s, String t) {
		char[] array = s.toCharArray();
		char[] array2 = t.toCharArray();
		
		for(int i =0; i < array.length; i ++) {
			for(int j=i; j > 0; j--){
				if(array[j] < array[j - 1]) {
					char aux = array[j - 1];
					array[j - 1] = array[j];
					array[j] = aux;
				}
				if(array2[j] < array2[j - 1]) {
					char aux = array2[j - 1];
					array2[j - 1] = array2[j];
					array2[j] = aux;
				}
			}
		}
		s = new String(array);
		t = new String(array2);
	    //System.out.println(s + " "+ t);		
		return s.compareTo(t) == 0;
	}
	
    public boolean isAnagram7(String s, String t) { 
    	if(s.length() != t.length() || s== null || t== null) {
    		return false;
    	}       
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        return Arrays.equals(array1, array2);
        
    }
    
    public boolean isAnagram8(String s, String t) { 
    	if(s.length() != t.length() || s== null || t== null) {
    		return false;
    	}       
        int differentWord[] = new int[26];
        
        for( int i = 0; i <s.length(); i++) {
        	differentWord[s.charAt(i)-'a']++;
        	differentWord[t.charAt(i)-'a']--;
        }
        for(int c: differentWord) {
        	if(c!=0) {
        		return false;
        	}
        }
        return true;
    }
    
    public boolean isAnagram9(String s, String t) { 
    	if(s.length() != t.length() || s== null || t== null) {
    		return false;
    	}       

    	Map<Character,Integer> hashTable = new HashMap<>();
    	
    	for(int i =0; i < s.length(); i++) {
    		if(hashTable.containsKey(s.charAt(i))) {
    			hashTable.put(s.charAt(i), hashTable.getOrDefault(s.charAt(i), 0) + 1);    			
    		}else {
    			hashTable.put(s.charAt(i), 1);    			
    		}
    	}
    	for(int i =0; i < s.length(); i++) {
    		if(hashTable.containsKey(t.charAt(i))) {
    			int count = hashTable.get(t.charAt(i));
    			if(count == 1) {
    				hashTable.remove(t.charAt(i));
    			}else {
    				hashTable.replace(t.charAt(i), count-1);
    			}
    		}else {
    			return false;
    		}
    	}
    	
        return hashTable.isEmpty();
    }
    
    
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> sChars = new HashMap<>();
        Map<Character,Integer> tChars = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i<s.length(); i++) {
            addToMap(sChars, s.charAt(i));
            addToMap(tChars, t.charAt(i));
        }
        return sChars.equals(tChars);
    }
    private void addToMap(Map<Character,Integer> map, char c) {
        if (map.keySet().contains(c)) {
            map.put(c,map.get(c)+1);
        } else {
            map.put(c,1);
        }
    }
    
    
}
