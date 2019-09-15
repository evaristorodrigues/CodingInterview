/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Evaristo
 *384. Shuffle an Array
 */
public class ShuffleAnArray {

	/**
	 * Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
	 */
	
	int[] nums = null;
	int[] cache = null;
	Random r = new Random();
	public ShuffleAnArray(int[] nums) {
		this.nums = nums;
		this.cache = nums.clone();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		int[] array = {1,2,3,4,5,6,7,8,9};
		ShuffleAnArray s = new ShuffleAnArray(array);
		System.out.println(Arrays.toString(s.shuffle()));
	}
	
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
 
        return this.cache;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	if(this.nums == null || this.nums.length == 0) {
    		return this.nums;
    	}
        for(int i =0; i < this.nums.length; i++) {
        	int pos = r.nextInt(this.nums.length - i) + i;
        	int aux = this.nums[i];
        	this.nums[i] = this.nums[pos];
        	this.nums[pos] = aux;        	
        }
    	return this.nums;
    }

}
