/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.HashMap;
import java.util.Map;

/**
 * @author evaristosrodrigues
 *
 */
public class CheckPermutation {

	/**
	 * @param args
	 */
	
	
	public boolean checkPermutation(String a, String b) {
		if( a.equals(b)) {
			return true;
		}else if( a== null || b == null) {
			return false;
		}
		Map<Character, Integer> character = new HashMap<Character, Integer>();
		for( char c : a.toCharArray()) {
			character.put(c,character.getOrDefault(c, 0)+1);
		}
		
		for(char c : b.toCharArray()) {
			if(!character.containsKey(c) || character.get(c) == 0) {
				return false;
			}else {
				character.put(c, character.get(c) -1);
			}
		}
		for(Integer value : character.values()) {
			if(value > 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		CheckPermutation cp = new CheckPermutation();
		System.out.println(cp.checkPermutation("evaristo", "evaristo"));
		System.out.println(cp.checkPermutation("evaristo", "evarsto"));
		System.out.println(cp.checkPermutation("abcde", "edcba"));
		System.out.println(cp.checkPermutation("2345", "12"));
		System.out.println(cp.checkPermutation("2222", "2"));
	}

}
