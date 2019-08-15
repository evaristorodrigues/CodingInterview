/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.Arrays;

/**
 * @author Evaristo
 *88. Merge Sorted Array
 */
public class MergeSortedArray {

	/**
	 * @param args
	 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
	 */
	public static void main(String[] args) {
		MergeSortedArray mS = new MergeSortedArray();
		int[] nums1 = {1,2,3,0,0,0,0,0,0,0};
		int m = 3;
		int[] nums2 = {4,5};
		int n = 2;
		mS.merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));

	}
	
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null) {
        	return;
        }        
        int pos = (m + n) -1;
        --m;--n;
        while(m>=0 || n>=0) {
        	if(n < 0 || m>=0 && nums1[m] >= nums2[n]) {
        		nums1[pos--]= nums1[m--];
        	}else {
        		nums1[pos--] = nums2[n--];
        	}
        }
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null) {
        	return;
        }        
        int pos = (m + n) -1;
        --m;--n;
        while(m>=0 && n>=0) {
        	if(nums1[m] >= nums2[n]) {
        		nums1[pos--]= nums1[m--];
        	}else {
        		nums1[pos--] = nums2[n--];
        	}
        }
        
        while(n >=0) {
        	nums1[pos--] = nums2[n--];
        }
    }

}
