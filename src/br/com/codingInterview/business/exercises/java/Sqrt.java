/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

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
		System.out.println(s.mySqrt(8));
	}
	
	public int mySqrt(int x) {
		int result = 1;
		while (x > 1) {

			if (x % 2 == 0) {
				result *= x / 2;
				x /= 2;
			}
			if (x % 3 == 0) {
				result *= x / 3;
				x /= 3;
			}
			if (x % 5 == 0) {
				result *= x / 5;
				x /= 5;
			}
			if (x % 7 == 0) {
				result *= x / 7;
				x /= 7;
			}
		}
		return result;
	}

}
