/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Evaristo
 *78. Subsets
 */
public class Subsets {

	/**
	 * 
	 */
	public Subsets() {
		// TODO Auto-generated constructor stub
	}

	/**
	 *Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Accepte
	 */
	public static void main(String[] args) {
		Subsets s = new Subsets();
		int[] nums = {1,2,3};
		System.out.println(Arrays.toString(s.subsets(nums ).toArray()));

	}
	
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	if(nums == null) {
    		return result;
    	}
 
    	findSubsets( result, new ArrayList<Integer>(), nums,0);
    	
        return result;
    }

	private void findSubsets(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
	  result.add(new ArrayList<Integer>(current));
	  for( int i = index; i < nums.length; i++ ) {
		  current.add(nums[i]);
		  findSubsets(result, current, nums, i+1);
		  current.remove(current.size()-1);
	  }
	}
	
}
