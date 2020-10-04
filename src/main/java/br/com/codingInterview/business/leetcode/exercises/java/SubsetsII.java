/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author evaristosrodrigues
 *90. Subsets II
 */
public class SubsetsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubsetsII  s = new SubsetsII();
		
		int[] nums = {1,2,2};
		System.out.println(Arrays.toString(s.subsetsWithDup(nums ).toArray()));
	}
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums == null) {
    		return result;
    	}
    	Arrays.sort(nums);
    	
    	findSubSet(nums,0,new ArrayList<Integer>(), result);
    	return result;
    }

	private void findSubSet(int[] nums, int index, ArrayList<Integer> current, List<List<Integer>> result) {
		result.add(new ArrayList<>(current));
		for( int i = index; i < nums.length; i++) {
			if( index == i || nums[i] != nums[i-1]) {
				current.add(nums[i]);
				findSubSet(nums, i+1, current, result);
				current.remove(current.size()-1);
			}
		}
		
	}

}
