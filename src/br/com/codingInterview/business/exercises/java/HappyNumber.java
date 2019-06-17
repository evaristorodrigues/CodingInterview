/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Evaristo
 *202. Happy Number
 */
public class HappyNumber {

	/**
	 * @param args Write an algorithm to determine if a number is "happy".
	 * 
	 *             A happy number is a number defined by the following process:
	 *             Starting with any positive integer, replace the number by the sum
	 *             of the squares of its digits, and repeat the process until the
	 *             number equals 1 (where it will stay), or it loops endlessly in a
	 *             cycle which does not include 1. Those numbers for which this
	 *             process ends in 1 are happy numbers.
	 * 
	 *             Example:
	 * 
	 *             Input: 19 Output: true 
	 *             Explanation: 
	 *             12 + 92 = 82 
	 *             82 + 22 = 68
	 *             62 + 82 = 100
	 *             12 + 02 + 02 = 1
	 */
	public static void main(String[] args) {
		HappyNumber h = new HappyNumber();
		int n =68;
		System.out.println(h.isHappy(n ));
	}
	
    public boolean isHappy2(int n) {
    	if(n < 1) {
    		return false;
    	}	
        if(n ==1) {
        	return true;
        }
        Set<Integer> values = new HashSet<>();
        while(n!= 1) {
        	char[] numbers = String.valueOf(n).toCharArray();
        	n= 0;
        	for(int i =0; i < numbers.length; i++) {
        	  n += Math.pow(numbers[i] -'0',2);	
        	}
        	if(values.contains(n)) {
        		return false;
        	}else {
        		values.add(n);
        	}        	
        }        
        return true;
    }
    
    public boolean isHappy(int n) {
    	if(n < 1) {
    		return false;
    	}	
        if(n ==1) {
        	return true;
        }
        Set<Integer> values = new HashSet<>();
       
        while(n != 1) {
        	int number=0;
	        while(n>0) {
	        	number+= Math.pow(n% 10,2);	 
	        	n = n / 10;
	        }
	    	if(values.contains(number)) {
	    		return false;
	    	}else {
	    		values.add(number);
	    	}    
	    	n = number;
        }
        return true;
    }

}
