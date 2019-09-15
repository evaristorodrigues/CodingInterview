/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *718. Maximum Length of Repeated Subarray
 */
public class MaximumLengthOfRepeatedSubarray {

	/**
	 * 
	 */
	public MaximumLengthOfRepeatedSubarray() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
 

Note:

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
 
	 */
	public static void main(String[] args) {
		MaximumLengthOfRepeatedSubarray m = new MaximumLengthOfRepeatedSubarray();
		int[] A = {1,2,3,2,1};
		int[] B = {3,2,1,4,7};
		System.out.println(m.findLength(A, B));

	}
    public int findLength(int[] A, int[] B) {
        if( A == null || B == null || A.length ==0 || B.length ==0) {
        	return 0;
        }
        int result =0;
        for( int i =0; i < A.length; i++) {        	
        	for(int j=0; j < B.length; j++) {        		
        		if(A[i] == A[j]) {
        		 int count = 1;
        		 int currentA =i++;
        		 int currentB = j++;
        		 while( currentA < A.length && currentB < B.length 
        				 && A[currentA] == B[currentB]) {
        			 count++;
        			 currentA++;
        			 currentB++;
        		 };
        		 result = Math.max(count, result);
        		} 
        	}
        }
     return result;        
    }
}
