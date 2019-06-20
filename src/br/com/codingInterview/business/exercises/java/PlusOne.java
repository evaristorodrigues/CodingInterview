/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.Arrays;

/**
 * @author Evaristo
 *
 */
public class PlusOne {

	/**
	 * Given a non-empty array of digits representing a non-negative integer, plus
	 * one to the integer.
	 * 
	 * The digits are stored such that the most significant digit is at the head of
	 * the list, and each element in the array contain a single digit.
	 * 
	 * You may assume the integer does not contain any leading zero, except the
	 * number 0 itself.
	 * 
	 * Example 1:
	 * 
	 * Input: [1,2,3] Output: [1,2,4] Explanation: The array represents the integer
	 * 123. Example 2:
	 * 
	 * Input: [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents the
	 * integer 4321.
	 */
	public static void main(String[] args) {
		PlusOne p = new PlusOne();
		int[] digits = { 1,9};
		System.out.println(Arrays.toString(p.plusOne(digits)));
	}

	public int[] plusOne2(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}
		boolean hasTogo = false, hasNewArray = false;
		int[] newArray = null;
		if (digits[0] == 9 && digits[digits.length - 1] == 9) {
			newArray = new int[digits.length + 1];
			newArray[0] = 1;
			hasNewArray = true;
		}
		for (int i = digits.length - 1; i >= 0; i--) {
			if (++digits[i] > 9) {
				digits[i] = 0;
				hasTogo = true;
			} else {
				hasTogo = false;
			}

			if (hasNewArray) {
				newArray[i + 1] = digits[i];
			}
			if (!hasTogo) {
				break;
			}
		}
		return hasTogo ? newArray : digits;
	}

	public int[] plusOne(int[] digits) {
          if(digits == null) {
        	  return null;
          }          
          for(int i = digits.length-1; i >=0; i--) {
        	  if(++digits[i] >9) {
        		  digits[i]=0;
        	  }else {
        		  return digits;
        	  }
          }          
          int[] newArray = new int[digits.length+1];
          newArray[0]=1;          
          return newArray;
	}

}
