/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo 326. Power of Three
 */
public class PowerOfThree {

	/**
	 * @param args
	 * 
	 *             Given an integer, write a function to determine if it is a power
	 *             of three.
	 * 
	 *             Example 1:
	 * 
	 *             Input: 27 Output: true Example 2:
	 * 
	 *             Input: 0 Output: false Example 3:
	 * 
	 *             Input: 9 Output: true Example 4:
	 * 
	 *             Input: 45 Output: false Follow up: Could you do it without using
	 *             any loop / recursion?
	 */
	public static void main(String[] args) {
		PowerOfThree p = new PowerOfThree();
		
		int n =243;
		System.out.println(p.isPowerOfThree(n));
	}
	
    public boolean isPowerOfThree2(int n) {
       return ((Math.log10(n) / Math.log10(3)) % 1 == 0);
   
    }
    //TODO debbugar
	public boolean isPowerOfThree(int n)
	{
		if(n > 1)
		{
			while(n % 3 == 0)
			{
				n /= 3;
			}
		}
		return n == 1;
	}

}
