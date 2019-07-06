/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo 172. Factorial Trailing Zeroes
 */
public class FactorialTrailingZeroes {

	/**
	 * @param args Given an integer n, return the number of trailing zeroes in n!.
	 * 
	 *             Example 1:
	 * 
	 *             Input: 3 Output: 0 Explanation: 3! = 6, no trailing zero. Example
	 *             2:
	 * 
	 *             Input: 5 Output: 1 Explanation: 5! = 120, one trailing zero.
	 *             Note: Your solution should be in logarithmic time complexity.
	 * 
	 *             Accep
	 */
	public static void main(String[] args) {
		FactorialTrailingZeroes f = new FactorialTrailingZeroes();
		int n = 245;
		System.out.println(f.trailingZeroes(n ));

	}
	
    public int trailingZeroes2(int n) {
        if(n == 0) {
        	return 0;
        }
        Long f = helperFatorial(n);
        int count=0;
        while(f%10==0) {
        	count++;
        	f/=10;
        }
        return count;
    }

	private Long helperFatorial(int f) {

		if(f<=0) {
			return 1l;
		}
		return f * helperFatorial(f -1);
	}
	
	 public int trailingZeroes(int n) {
		 int count = 0;
		 while(n >= 5) {
			n/=5;
			count+=n;
		 }
		 return count;
	 }

}
