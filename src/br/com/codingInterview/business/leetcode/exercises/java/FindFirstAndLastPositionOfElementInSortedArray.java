/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.Arrays;

/**
 * @author Evaristo
 *
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

	/**
	 * 
	 */
	public FindFirstAndLastPositionOfElementInSortedArray() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
	 */
	public static void main(String[] args) {
		FindFirstAndLastPositionOfElementInSortedArray f = new FindFirstAndLastPositionOfElementInSortedArray();
		int[] nums = {8,8,8,8,8,8,8,10};
		int target = 8;
		System.out.println(Arrays.toString(f.searchRange(nums, target)));

	}
	
    public int[] searchRange(int[] nums, int target) {
    	//Inicializa ambos com -1, em caso de não encontrar.
     int[] result = {-1, -1};
     //Busca o primeiro elemento
     int idx = helperSearchRange(nums, target,true); 
     //Caso não encontre, retorna -1 nos dois.
     if(idx == nums.length || nums[idx] != target) {
    	 return result;
     }
     //se encontrar deixa a posição com o primeiro elemento.
     result[0] = idx;
     //Busca o ultimo elemento, e passa -1. pois o retorno é o primeiro elemento maior que o target
     result[1] = helperSearchRange(nums, target,false)-1;
     return result;
    }

	private int helperSearchRange(int[] nums, int target, boolean isLeft) {
	        int left=0;
	        int right =nums.length;        
	        while(left < right) {
	        	int mid = left + ( right - left)/2;
	        	//Se for left vai para a esquerda tambem quando for igual, se não vai para a esquerda somente quando for maior
	        	if(nums[mid] > target || nums[mid] == target && isLeft) {
                  right = mid;
	        	}else {
	        		//Vai para a direita quando o elemento dor menor que o solicitado ou quando left for false e eo elemento for igual
	        		left = mid +1;
	        	}
	        }        
	        return left;
	}

}
