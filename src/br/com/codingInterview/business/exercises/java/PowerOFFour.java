/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo 342. Power of Four
 *
 */
public class PowerOFFour {

	/**
	 * @param args Given an integer (signed 32 bits), write a function to check
	 *             whether it is a power of 4.
	 * 
	 *             Example 1:
	 * 
	 *             Input: 16 Output: true Example 2:
	 * 
	 *             Input: 5 Output: false Follow up: Could you solve it without
	 *             loops/recursion?
	 */
	public static void main(String[] args) {
		PowerOFFour p = new PowerOFFour();
		int num = 16;
		System.out.println(p.isPowerOfFour(num ));

	}
	
    public boolean isPowerOfFour(int num) {
        return (Math.log10(num) / Math.log10(4)) % 1 == 0;
    }

}
