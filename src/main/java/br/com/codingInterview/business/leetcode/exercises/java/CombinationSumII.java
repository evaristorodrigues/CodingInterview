/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author evaristosrodrigues
 *
 */
public class CombinationSumII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CombinationSumII c = new CombinationSumII();
		
		int target = 8;
		int[] candidates = {10,1,2,7,6,1,5};
		System.out.println(Arrays.toString(c.combinationSum2(candidates , target).toArray()));

	}
	
	//10,1,2,7,6,1,5
	 
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if( candidates == null || candidates.length ==0) {
    		return result;
    	}
    	Arrays.sort(candidates);
    	helper(candidates, target,0,new ArrayList<Integer>(),result);
    	return result;
    }

	private void helper(int[] candidates, int target, int index, ArrayList<Integer> current, List<List<Integer>> result) {
		if(target == 0) {
			result.add(new ArrayList<Integer>(current));
			return;
		}
		if(target < 0) {
		  return;	
		}
		
		for( int i = index; i < candidates.length; i++) {
			if(i == index || candidates[i] != candidates[i - 1]) {
				current.add(candidates[i]);
				helper(candidates, target-candidates[i] , i+1, current, result);
				current.remove(current.size() - 1);
			}
		}
	}

}
