/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *69. Sqrt(x)
 */
public class Sqrt {

	/**
	 * @param args
	 * Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
	 */
	public static void main(String[] args) {
		Sqrt s = new Sqrt();
		System.out.println(s.mySqrt(25));
	}
	
	//binary i*i<=x  && (i+1)(i+1) > x
	public int mySqrt2(int x) {
		if(x ==0) {
			return x;
		}
		int start =1;
		int end =x;
		while(start < end) {
			int mid = start+(end - start)/2;
			if(mid <= x/mid && ( mid +1) > x /(mid+1)) {
				return mid;
			}
			if(mid > x/ mid) {
			  end = mid;	
			}else {
				start = mid+1;
			}
		}
		return start;
	}
	//Newton Solution - i = (i + x / i) / 2
	public int mySqrt3(int x) {
		if(x ==0) {
			return x;
		}
		long i =x;
		
		while(i > x/i) {
           i = (i+x/i)/2;
		}
		return(int) i;
	}
	//Brute Force
	public int mySqrt(int x) {
		if(x ==0) {
			return x;
		}
		for( int i = 1; i <= x/i; i++) {
			if(i <= x/i && (i+1) > x/(i+1)) {
				return i;
			}
		}
		return -1;
	}
	
	

}
