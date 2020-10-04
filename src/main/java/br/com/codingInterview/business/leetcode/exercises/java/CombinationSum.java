/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author evaristosrodrigues
 *39. Combination Sum
 */
public class CombinationSum {

	/**
	 * @param args
	 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
	 */
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = {2,3,6,7};
		int target = 7;
		System.out.println(Arrays.toString(cs.combinationSum(candidates, target ).toArray()));
	}

    public List<List<Integer>> combinationSum(int[] candidates, int target) { 
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(candidates == null) {
    		return result;
    	}
    	findCombinationSum(candidates,0,target,new ArrayList<Integer>(),result); 
    	
    	return result;
    }

	private void findCombinationSum(int[] candidates, int index, int target, List<Integer> current,List<List<Integer>> result) {
    
	  if(target ==0) {
    	  result.add(new ArrayList<Integer>(current));
      }
      
      if(target < 0) {
    	  return;
      }
      
      for(int i =index; i < candidates.length; i++) {
    	  current.add(candidates[i]);
    	  findCombinationSum(candidates, i, target- candidates[i], current, result);
    	  current.remove(current.size() - 1);
      }      
	}
}
