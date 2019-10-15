/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *33. Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {

	/**
	 * 
	 */
	public SearchInRotatedSortedArray() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
		int[] nums = {4,5,6,7,0,1,2};
		int target = 8;
		System.out.println(s.search(nums, target));
	}
	
    public int search(int[] nums, int target) {
    	if(nums == null || nums.length ==0) {
    		return -1;
    	}
    	int left = 0;
    	int right = nums.length -1;
        while(left <= right) {
            int mid = left +(right - left) / 2;
            if( nums[mid] == target) {
            	return mid;
            }else if(nums[left] <= nums[mid]) {
            	if(target >= nums[left] && target < nums[mid]) {
            		right = mid -1;
            	}else {
            		left = mid +1;
            	}
            }else if(nums[mid] <= nums[right]) {
            	if(target <= nums[right] && target > nums[mid]) {
            		left = mid +1;
            	}else {
            		right = mid -1;
            	}
            }
        }    	
		return -1;        
    }

}
