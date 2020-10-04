/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author evaristosrodrigues
 *
 */
public class FindAllAnagramsInAString {

	/**
	 * @param args
	 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//abab
	
	//ab
	
	public List<Integer> findAnagrams(String s, String p) {
    	List<Integer> result = new ArrayList<Integer>();
    	if(s== null || p == null) {
    		return result;
    	}
    	int[] arrayS = new int[26];
    	int[] arrayP = new int[26];
        for(int i =0; i < p.length(); i++) {
        	arrayP[p.charAt(i) - 'a']++;
        	arrayS[s.charAt(i) - 'a']++;
        }
        for(int k=0; k <=s.length()-p.length(); k++) {
        	
        	if(compare(arrayS, arrayP)) {
        		result.add(k);
        	}
        	if(k+p.length() >= s.length()) {
	        	arrayS[s.charAt(k) - 'a']--;
	        	arrayS[s.charAt(k+p.length()) - 'a']++;
        	}
        }      	
        return result;
    }

	private boolean compare(int[] arrayS, int[] arrayP) {
		for(int i =0; i < 26; i++) {
			if(arrayS[i] != arrayP[i]){
				return false;
			}
		}
		return true;
	}

}
