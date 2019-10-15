/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Evaristo
 *46. Permutations
 */
public class Permutations {

	/**
	 * 
	 */
	public Permutations() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] array = {1,2,3};
	    for(List<Integer> lista: p.permute(array)) {
	    	for(Integer i: lista) {
	    		System.out.print(i+" ");
	    	}
	    	System.out.println("");
	    }

	}
	
    public List<List<Integer>> permute2(int[] nums) {
       List<List<Integer>> permutations = new ArrayList<List<Integer>>();
       Arrays.sort(nums);
       fillList(permutations, nums);
       return helperPermute(nums, permutations);
    }
    //My crazy solution
	private List<List<Integer>> helperPermute(int[] array, List<List<Integer>> permutations) {
		int idx_low = array.length -2;
		while(idx_low >=0 && array[idx_low] >= array[idx_low + 1])
			idx_low --;
		if(idx_low >=0) {
			int idx_high = array.length -1;
			while(idx_high >idx_low && array[idx_high] <= array[idx_low])
				idx_high --;
			swap(array,idx_low,idx_high);
			reverse(array,idx_low+1,array.length-1);
			fillList(permutations, array);
			return helperPermute(array,permutations);
		}else {
			return permutations;
		}
		
	}

	private void fillList(List<List<Integer>> permutations, int[] array) {
		List<Integer> lista = new ArrayList<Integer>();
		for( int i = 0; i < array.length; i++) {
			lista.add(array[i]);
		}
		permutations.add(lista);
	}

	private void swap(int[] array, int idx_low, int idx_high) {
		int aux = array[idx_low];
		array[idx_low] = array[idx_high];
		array[idx_high] = aux;	
	}

	private void reverse(int[] array, int begin, int end) {
		int max = end - begin-1;
		for( int i = 0; i <=max/2; i++) {
			swap(array, begin +i, end-i);
		}
		
	}

	
	//Iterating
	public List<List<Integer>> permute3(int[] num) {	    
	List<List<Integer>> result = new ArrayList<List<Integer>>();		
    if(num== null || num.length < 1) {
    	return result;
    }
    List<Integer> list = new ArrayList<Integer>();
    list.add(num[0]);
    result.add(list);
	for(int i=1; i < num.length; i++) {
	    List<List<Integer>> tempAns = new ArrayList<List<Integer>>();
		for(int j=0; j<=i;j++) {			
			for(List<Integer> l:result) {
				List<Integer> newList = new ArrayList<Integer>(l);
				newList.add(j, num[i]);
				tempAns.add(newList);
			}
		}
		result = tempAns;
	}    
    return result;
	}
	public List<List<Integer>> permute4(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(num== null || num.length < 1) {
			return result;
		}
		List<Integer> tempList = new ArrayList<Integer>();
		helperPermutation(num,tempList,result );
		return result;
	}

	private void helperPermutation(int[] num, List<Integer> tempList, List<List<Integer>> result) {
		if(tempList.size() == num.length) {
			result.add(new ArrayList<Integer>(tempList));
		}else {
			for(int i =0; i <=tempList.size(); i++) {
				tempList.add(i, num[tempList.size()]);
				helperPermutation(num,tempList,result );
				tempList.remove(i);
			}			
		}
	}
	//Slow, the other is faster
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(num== null || num.length < 1) {
			return result;
		}
		List<Integer> tempList = new ArrayList<Integer>();
		helper(num,tempList,result );
		return result;
	}

	private void helper(int[] num, List<Integer> tempList, List<List<Integer>> result) {
		if(tempList.size() == num.length) {
			result.add(new ArrayList<Integer>(tempList));
		}else {
			for(int i =0; i < num.length; i++) {
				if(tempList.contains(num[i])) {
					continue;
				}				
				tempList.add(num[i]);
				helper(num, tempList, result);
				tempList.remove(tempList.size()-1);
			}
		}
		
	}
	
	
}
