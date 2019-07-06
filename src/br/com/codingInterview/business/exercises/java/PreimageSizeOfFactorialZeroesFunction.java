/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo 793. Preimage Size of Factorial Zeroes Function
 */
public class PreimageSizeOfFactorialZeroesFunction {

	/**
	 * @param args Let f(x) be the number of zeroes at the end of x!. (Recall that
	 *             x! = 1 * 2 * 3 * ... * x, and by convention, 0! = 1.)
	 * 
	 *             For example, f(3) = 0 because 3! = 6 has no zeroes at the end,
	 *             while f(11) = 2 because 11! = 39916800 has 2 zeroes at the end.
	 *             Given K, find how many non-negative integers x have the property
	 *             that f(x) = K.
	 * 
	 *             Example 1: Input: K = 0 Output: 5 Explanation: 0!, 1!, 2!, 3!,
	 *             and 4! end with K = 0 zeroes.
	 * 
	 *             Example 2: Input: K = 5 Output: 0 Explanation: There is no x such
	 *             that x! ends in K = 5 zeroes. Note:
	 * 
	 *             K will be an integer in the range [0, 10^9].
	 */
	public static void main(String[] args) {
		PreimageSizeOfFactorialZeroesFunction p = new PreimageSizeOfFactorialZeroesFunction();
		int k = 122;
        System.out.println(p.preimageSizeFZF(k));
	}
	
    public int preimageSizeFZF(int k) {
     int aux=0;
     if(k < 30) {
    	 k = 1;
     }else { 
    	int div = k /30;
    	int j = k %30 >= (div-2)?div -1:div > 2?1:0;
    	aux = j*-1;
     }   
     
      if((k+aux) % 6 == 0) {
    	  return 0;
      }else {
    	  return 5;
      }
     
     
        
    }

}
