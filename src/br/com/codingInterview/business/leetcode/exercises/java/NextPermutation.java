/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.Arrays;

/**
 * @author Evaristo
 *31. Next Permutation
 */
public class NextPermutation {

	/**
	 * 
	 */
	public NextPermutation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NextPermutation nP = new NextPermutation();
		int[] array = {1,5,1};
		nP.nextPermutation(array);
		System.out.println(Arrays.toString(array));
	}
	//My solution
    public void nextPermutation2(int[] nums) {
        if(nums == null || nums.length < 2) {
        	return;
        }
        int idx_low = 0;
        int idx_high=0;
        boolean  founded = false;
        
        for(int i =nums.length-2; i >=0; i --) {
        	if(nums[i] < nums[i + 1]) {
        		idx_low= i;
        		founded=true;
        		break;
        	}
        }
        
        if(founded) {
        	for(int i = nums.length - 1; i > idx_low; i --) {
        		if(nums[i] > nums[idx_low]) {
        			idx_high = i;
        			break;
        		}
        	}
        	swap(nums,idx_low, idx_high);
        	lexicographicalOrder(nums, idx_low + 1, nums.length - 1);
        }else {
        	lexicographicalOrder(nums, 0, nums.length - 1);
        }
    }

	private void lexicographicalOrder(int[] nums, int begin, int end) {
		int qtd = end - begin;
		for(int i =0; i <= qtd/2;i++) {
			swap(nums,begin +i, end -i );
		}		
	}

	private void swap(int[] nums, int idx_low, int idx_high) {
		int aux = nums[idx_low];
		nums[idx_low] = nums[idx_high];
		nums[idx_high]=aux;		
	}
	
    public void nextPermutation(int[] nums) {
    	if(nums== null || nums.length < 2) {
    		return;
    	}
    	int idx_low = nums.length - 2;
    	while(idx_low >=0 && nums[idx_low] >= nums[idx_low + 1])
    		idx_low--;    		

    	if(idx_low >=0) {
    		int idx_high = nums.length - 1;
        	while(idx_high >idx_low && nums[idx_high] <= nums[idx_low])
        		idx_high--;
        	
        	swaps(nums, idx_low, idx_high);
    	}
    	reverse(nums, idx_low + 1, nums.length -1);
    }

	private void reverse(int[] nums, int begin, int end) {
		int qtd = end - begin;
		for(int i =0; i <= qtd/2;i++) {
			swaps(nums,begin +i, end -i );
		}
		
	}
	
	private void swaps(int[] nums, int idx_low, int idx_high) {
		int aux = nums[idx_low];
		nums[idx_low] = nums[idx_high];
		nums[idx_high]=aux;		
	}
	

}
