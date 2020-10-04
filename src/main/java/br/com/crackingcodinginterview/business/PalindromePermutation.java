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
public class PalindromePermutation {

	/**
	 * @param args
	 */
	
	public boolean isPalindromePermutation(String s) {
		if(s == null || s.length() == 0) {
			return true;
		}		
		int [] character = new int[getNumberCharacter('z') - getNumberCharacter('a')+1];
		int letters =0;
		for( char c : s.toCharArray()) {
			int val = getNumberCharacter(c);
			if(val!= -1) {
				letters++;
				if(character[val] > 0 ) {
					character[val] = 0;
				}else {
					character[val] =1;
				}				
			}
		}
	    int count = 0;
		for(Integer value: character) {
		  if(value > 0) {
			count++;
		  }
		}
        if(letters % 2 ==0 && count > 0) {
        	return false;
        }else  if( count > 1) {
        	return false;
        }		
		return true;
	}
	
	public int getNumberCharacter(Character val) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int c = Character.getNumericValue(val);
		
		if( c> z || c < a) {
			return -1;
		}else {
			return c - a;
		}
	}
	public static void main(String[] args) {
		PalindromePermutation pp = new PalindromePermutation();
		System.out.println(pp.isPalindromePermutation("evaristo"));
		System.out.println(pp.isPalindromePermutation("aea"));
		System.out.println(pp.isPalindromePermutation("aaaj aaa"));
		System.out.println(pp.isPalindromePermutation("Tact Coa"));
		System.out.println(pp.isPalindromePermutation("Tact Coa."));
		System.out.println(pp.isPalindromePermutation("Tact Cuoa"));
		
	}

}
