/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *704. Binary Search
 */
public class BinarySearch {

	/**
	 * 
	 */
	public BinarySearch() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();
        int target = 12;
		int[] nums = {-1,0,3,5,9,12};
		System.out.println(b.search(nums, target));
	}
	//recursive
    public int search2(int[] nums, int target) {
    	return helper(nums,0, nums.length - 1, target);
    }

	private int helper(int[] nums, int start, int end, int target) {
        int mid = (end + start) / 2;
        if(start > end ) {
        	return -1;
        } else if(nums[mid] == target) {
        	return mid;
        }else if(nums[mid] > target) {
        	return helper(nums, start,mid-1, target);
        }else{
        	return helper(nums, mid+1,end, target);
        }
	}
	
	//Iterative
    public int search(int[] nums, int target) {
      int left =0;
      int rigth = nums.length - 1;  
      int mid =0;
      while(left <= rigth) {
    	  mid =(left + rigth) / 2;
    	  if(nums[mid] == target) {
    		  return mid;
    	  }else if(nums[mid]  < target) {
    		   left = mid+1;
    	  }else {
    		  rigth = mid-1;
    	  }
      }
     return -1;
    }

}
