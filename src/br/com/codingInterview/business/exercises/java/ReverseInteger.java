/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo
 *7. Reverse Integer
 */
public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseInteger rI = new ReverseInteger();
		
		System.out.println(rI.reverse(120));

	}

    public int reverse(int x) {
    	int reversed =0;
        while(x!=0) {
        	int module = x%10;
        	if(reversed > (Integer.MAX_VALUE/ 10) || reversed ==  (Integer.MAX_VALUE/ 10) && module > 7 ||
        			reversed < (Integer.MIN_VALUE/ 10)	|| reversed == (Integer.MIN_VALUE/ 10) && module >8) {
        		return 0;
        	}
        	reversed = reversed* 10 + module;
        	x/=10;
        }
        
        return reversed;
    }

}
