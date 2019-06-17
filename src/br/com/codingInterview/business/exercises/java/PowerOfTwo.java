/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo 231. Power of Two
 */
public class PowerOfTwo {

	/**
	 * @param args
	 * 
	 *             Given an integer, write a function to determine if it is a power
	 *             of two.
	 * 
	 *             Example 1:
	 * 
	 *             Input: 1 Output: true Explanation: 20 = 1 Example 2:
	 * 
	 *             Input: 16 Output: true Explanation: 24 = 16 Example 3:
	 * 
	 *             Input: 218 Output: false
	 */
	public static void main(String[] args) {
		PowerOfTwo p = new PowerOfTwo();
		int n = 16;
		System.out.println(p.isPowerOfTwo(n ));

	}
	
	
    public boolean isPowerOfTwo2(int n) {
        
    	while(n%2==0) {
    		n/=2;
    	}
    	
    	return n ==1;
    }
    
    public boolean isPowerOfTwo3(int n) {
          	
    	return (Math.log10(n)/Math.log10(2))% 1== 0;
    }
    //FIXME Estudar
    public boolean isPowerOfTwo(int n) 
    {
        return n > 0 && (n & n - 1) == 0;
    }

}
