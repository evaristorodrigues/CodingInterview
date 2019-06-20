/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo 191. Number of 1 Bits
 */
public class NumberOf1Bits {

	/**
	 * @param args
	 * 
	 *             Write a function that takes an unsigned integer and return the
	 *             number of '1' bits it has (also known as the Hamming weight).
	 * 
	 * 
	 * 
	 *             Example 1:
	 * 
	 *             Input: 00000000000000000000000000001011 Output: 3 Explanation:
	 *             The input binary string 00000000000000000000000000001011 has a
	 *             total of three '1' bits. Example 2:
	 * 
	 *             Input: 00000000000000000000000010000000 Output: 1 Explanation:
	 *             The input binary string 00000000000000000000000010000000 has a
	 *             total of one '1' bit. Example 3:
	 * 
	 *             Input: 11111111111111111111111111111101 Output: 31 Explanation:
	 *             The input binary string 11111111111111111111111111111101 has a
	 *             total of thirty one '1' bits.
	 * 
	 * 
	 *             Note:
	 * 
	 *             Note that in some languages such as Java, there is no unsigned
	 *             integer type. In this case, the input will be given as signed
	 *             integer type and should not affect your implementation, as the
	 *             internal binary representation of the integer is the same whether
	 *             it is signed or unsigned. In Java, the compiler represents the
	 *             signed integers using 2's complement notation. Therefore, in
	 *             Example 3 above the input represents the signed integer -3.
	 * 
	 * 
	 *             Follow up:
	 * 
	 *             If this function is called many times, how would you optimize it?
	 */
	public static void main(String[] args) {
		NumberOf1Bits nb = new NumberOf1Bits();
		int n = 15;
		System.out.println(nb.hammingWeight(n ));
		
	   

	}
	
    // you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
      String b = Integer.toBinaryString(n);
      b = b.replaceAll("0", "").trim();        
      return b.length();
    }
    
    public int hammingWeight3(int n) {
    	int result = 0;
    	
    	while(n!=0) {
    		result +=(n & 1);
    		n >>>= 1;
    	}
        
    	return result;
      }
    
    public int hammingWeight4(int n) {
    	int result = 0;
    	int shift = 1;
    	
    	for( int i = 0; i < 32; i++) {
    		
    		if((n & shift) !=0) {
    			result++;
    		}
    		shift <<= 1;
    	}        
        
    	return result;
      }
    
    public int hammingWeight(int n) {
    	int result = 0;

    	while(n!=0) {
    		result++;
    		n = n & (n-1);
    	}
    	return result;
      }

}
