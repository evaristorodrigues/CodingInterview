/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Evaristo
 *
 */
public class UglyNumber {

	/**
	 * 263. Ugly Number
	 */
	public UglyNumber() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UglyNumber uN = new UglyNumber();
	    System.out.println(uN.isUgly(0)); 
	}
	

    public boolean isUgly2(int num) {
    	if(num < 1) {
    		return false;
    	}
    	
    	while(num%2 ==0) {
    		num/=2;
    	}
    	while(num%3 ==0) {
    		num/=3;
    	}
    	while(num%5==0) {
    		num/=5;
    	}
      return num ==1;
    }

    public boolean isUgly(int num) {
    	if(num == 1) {
    		return true;
    	} 
    	if(num ==0) {
    		return false;
    	}
      return  isUgly(num, 2) ||  isUgly(num, 3) ||  isUgly(num, 5); 
    }

	private boolean isUgly(int num, int i) {
		return num%i==0?isUgly(num/i):false;
	}
	

}
