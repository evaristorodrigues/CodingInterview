/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo
 *371. Sum of Two Integers
 */
public class SumOfTwoIntegers {

	/**
	 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = -2, b = 3
Output: 1
	 */
	public static void main(String[] args) {
		SumOfTwoIntegers s = new SumOfTwoIntegers();
		System.out.println("resultado="+s.getSum3(5, -10));

	}
	
    public int getSum(int a, int b) {
    	System.out.println(" A="+Integer.toBinaryString(a));
    	System.out.println(" B="+Integer.toBinaryString(b));
    	System.out.println("#####Bitwise#####");
    	int count = 1;
        while (b != 0) {
        	System.out.println("loop "+count++);
            int c = ((a & b) << 1);
            a ^= b;
            b = c;
            System.out.println("c = (a & b) << 1");
            System.out.println("a ^= b");
            System.out.println("b = c");
        	System.out.println(" A="+Integer.toBinaryString(a));
        	System.out.println(" B="+Integer.toBinaryString(b));
        	System.out.println(" c="+Integer.toBinaryString(c));
        }
        return a;
    }
    ;
    public int getSum2(int a, int b) {
    	if(b == 0) {
    		return a;
    	}    	
    	int c = (a&b) <<1;
    	a ^=b;
    	b = c;
    	return getSum2(a,b);
    }
    
    public int getSum3(int a, int b) {
    	while(b != 0) {    	   	
	    	int c = (a&b) <<1;
	    	a ^=b;
	    	b = c;
    	}
    	return a;
    }
    

}
