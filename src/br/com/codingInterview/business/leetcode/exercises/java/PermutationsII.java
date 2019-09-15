/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sun.media.sound.MidiUtils.TempoCache;

/**
 * @author Evaristo
 *47. Permutations II
 */
public class PermutationsII {

	/**
	 * 
	 */
	public PermutationsII() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PermutationsII p = new PermutationsII();
	    int[] array  = {1,2,1};
		for(List<Integer> lista: p.permuteUnique(array  )) {
	    	for(Integer i: lista) {
	    		System.out.print(i+" ");
	    	}
	    	System.out.println("");
	    }

	}
	
    public List<List<Integer>> permuteUnique2(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	boolean[] used = new boolean[nums.length];
    	Arrays.sort(nums);
    	helperPermute(nums, result, new ArrayList<Integer>(), used);
		return result;
    }

	private void helperPermute(int[] nums, List<List<Integer>> result, ArrayList<Integer> tempList, boolean[] used) {
		if(tempList.size() == nums.length) {
			result.add(new ArrayList<Integer>(tempList));
		}else {
			for(int i =0; i <nums.length; i++) {
				if(used[i] || i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue; 
				tempList.add( nums[i]);
				used[i]=true;
				helperPermute(nums, result, tempList, used);
				tempList.remove(tempList.size()-1);
				used[i] = false;
			}
		}
		
	}
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	if(nums ==  null || nums.length==0) return result;
    	
        List<Integer> l0 = new ArrayList<Integer>();
        
        Arrays.sort(nums);
        
        l0.add(nums[0]);
        result.add(l0);
        
        for(int i =1; i < nums.length; i++) {
        	List<List<Integer>> tempList = new ArrayList<List<Integer>>();
        	for(int j=0; j <= i; j++) {
        		
        		for(List<Integer> l : result) {
        			List<Integer> newList = new ArrayList<Integer>(l);
        			newList.add(j,nums[i]);
        			tempList.add(newList);
        			if(newList.get(j) == nums[i]);
        		}
        	}
        	result= tempList;
        }
    	
		return result;
    }

}
