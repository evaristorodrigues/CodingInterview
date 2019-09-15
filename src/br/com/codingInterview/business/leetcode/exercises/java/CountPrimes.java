/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *204. Count Primes 
 */
public class CountPrimes {

	/**
	 * Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
	 */
	public CountPrimes() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(499979));
	}
    public int countPrimes2(int n) {
	    boolean[] isNotPrime = new boolean[n];
	    int count= 0;
	    if(n < 3) {
	    	return 0;
	    }	    
	    for(int i =2; i < n; i++) {
	    	if(!isNotPrime[i]) {
	    		count++;
	    		if(i < Math.sqrt( n)){
		    		for(int j=i*i; j<n; j+=i) {
		    			isNotPrime[j]=true;
		    		}	
	    		}
	    	}
	    }	    
	    return count;        	
    }
    
    public int countPrimes(int n) {
	    boolean[] isNotPrime = new boolean[n];
	    int count= 0;
	    if(n < 3) {
	    	return 0;
	    }	    
	    for(int i =2; i < n; i++) {
	    	if(!isNotPrime[i]) {
	    		count++;	    		
		    		for(int j=2; j*i<n; j++) {
		    			isNotPrime[j*i]=true;
		    		}	
	    		}
	    }	    
	    return count;        	
    }

}
