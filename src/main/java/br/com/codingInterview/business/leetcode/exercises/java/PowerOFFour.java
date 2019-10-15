/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

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
		int num = 63;
		System.out.println(p.isPowerOfFour(num ));

	}
	
    public boolean isPowerOfFour2(int num) {
        return (Math.log10(num) / Math.log10(4)) % 1 == 0;
    }
    
    public boolean isPowerOfFour(int num) {
        return isPowerOfTwo(num) && isDividedByThree(num - 1);
    }

	private boolean isPowerOfTwo(int num) {
		
		return num  > 0 && ( num & (num - 1)) ==0;
	}

	private boolean isDividedByThree(int i) {
		// TODO Auto-generated method stub
		return i % 3 == 0;
	}

}
