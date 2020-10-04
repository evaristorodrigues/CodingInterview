/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author evaristosrodrigues
 *17. Letter Combinations of a Phone Number
 */
public class LetterCombinationsOfAPhoneNumber {

	/**
	 * @param args
	 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
	 */
	public static void main(String[] args) {
      LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
      System.out.println(Arrays.toString(l.letterCombinations("134").toArray()));
	}
	
    public List<String> letterCombinations(String digits) {
    	
    	List<String> result = new ArrayList<String>();   
    	
    	if(digits == null || digits.length() == 0) {
    		return result;
    	}
    String[] mappings = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
		/*
		 * for (int f = 0; f < digits.length(); f++) { int digit =
		 * Integer.parseInt(digits.substring(f, f+1)); char[] characters =
		 * mappings[digit].toCharArray();
		 * 
		 * for (int i = 0; i < characters.length; i++) {
		 * 
		 * StringBuilder combination = new StringBuilder();
		 * combination.append(characters[i]+"");
		 * 
		 * for (int j = f + 1; j < digits.length(); j++) {
		 * 
		 * int d = Integer.parseInt(digits.substring(j, j+1)); char[] ch =
		 * mappings[d].toCharArray();
		 * 
		 * for (int k = 0; k < ch.length; k++) { combination.append(ch[k]); } }
		 * result.add(combination.toString()); } }
		 */
    	
    	makeCombinatios(digits, mappings,"",result,0);
    	return result;
    }

	private void makeCombinatios(String digits, String[] mappings, String current, List<String> result, int indice) {
		if(indice == digits.length()) {
			result.add(current);
			return;
		}
		
		String letters = mappings[digits.charAt(indice)-'0'];
		
		for( int i =0; i < letters.length(); i++) {
			makeCombinatios(digits, mappings, current+letters.charAt(i), result, indice+1);
		}
		

	}

}
