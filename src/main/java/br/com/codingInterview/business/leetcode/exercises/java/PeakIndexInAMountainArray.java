/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *852. Peak Index in a Mountain Array
 */
public class PeakIndexInAMountainArray {

	/**
	 * Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

Example 1:

Input: [0,1,0]
Output: 1
Example 2:

Input: [0,2,1,0]
Output: 1
Note:

3 <= A.length <= 10000
0 <= A[i] <= 10^6
A is a mountain, as defined above.
	 */
	public PeakIndexInAMountainArray() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PeakIndexInAMountainArray p = new PeakIndexInAMountainArray();
		int[] array = {0,1,3,2};
		System.out.println(p.peakIndexInMountainArray(array));

	}
	
    public int peakIndexInMountainArray(int[] A) {
    	int left =0;
    	int right = A.length-1;
    	
    	while(left < right) {
    		int mid = left +(right - left)/2;
    		if(A[mid] < A[mid +1]) {
    			left = mid+1;
    		}else {
    			right =  mid;
    		}
    		
    	}
    	return left;
        
    }

}
