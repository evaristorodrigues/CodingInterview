/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.Arrays;

/**
 * @author Evaristo 80. Remove Duplicates from Sorted Array II
 */
public class RemoveDuplicatesFromSortedArrayII {

	/**
	 * @param args Given a sorted array nums, remove the duplicates in-place such
	 *             that duplicates appeared at most twice and return the new length.
	 * 
	 *             Do not allocate extra space for another array, you must do this
	 *             by modifying the input array in-place with O(1) extra memory.
	 * 
	 *             Example 1:
	 * 
	 *             Given nums = [1,1,1,2,2,3],
	 * 
	 *             Your function should return length = 5, with the first five
	 *             elements of nums being 1, 1, 2, 2 and 3 respectively.
	 * 
	 *             It doesn't matter what you leave beyond the returned length.
	 *             Example 2:
	 * 
	 *             Given nums = [0,0,1,1,1,1,2,3,3],
	 * 
	 *             Your function should return length = 7, with the first seven
	 *             elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3
	 *             respectively.
	 * 
	 *             It doesn't matter what values are set beyond the returned length.
	 *             Clarification:
	 * 
	 *             Confused why the returned value is an integer but your answer is
	 *             an array?
	 * 
	 *             Note that the input array is passed in by reference, which means
	 *             modification to the input array will be known to the caller as
	 *             well.
	 * 
	 *             Internally you can think of this:
	 * 
	 *             // nums is passed in by reference. (i.e., without making a copy)
	 *             int len = removeDuplicates(nums);
	 * 
	 *             // any modification to nums in your function would be known by
	 *             the caller. // using the length returned by your function, it
	 *             prints the first len elements. for (int i = 0; i < len; i++) {
	 *             print(nums[i]); }
	 */
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
		int[] nums = { 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4 };
		System.out.println(r.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));

	}

	// 1,1,1,2,2,3
	public int removeDuplicates2(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int countDuplicates = 0;
		int value = Integer.MIN_VALUE;
		int countSameValue = 0;
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (nums[i] == value) {
				if (countSameValue >= 2) {
					countDuplicates++;
					remove(nums, i);
					i--;
					length--;
				}
				countSameValue++;
			} else {
				value = nums[i];
				countSameValue = 1;
			}
		}
		return nums.length - countDuplicates;
	}

	private void remove(int[] nums, int start) {
		for (int i = start; i < nums.length - 1; i++) {
			nums[i] = nums[i + 1];
		}

	}

  public int removeDuplicates(int[] nums) {
		int count = 0;
		int limit = 2;

		for (int i = 0; i < nums.length; i++) {
			// Se o valor de count de validos for menor qe o limite e o valor
			// atual for maior que duas
			// posições para traz referente ao count de validos é valido;
			if (count < limit || nums[i] > nums[count - limit]) {
				nums[count++] = nums[i];
			}
		}

		return count;
	}
}
