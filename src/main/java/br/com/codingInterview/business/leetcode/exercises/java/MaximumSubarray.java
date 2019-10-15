/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 * 53. Maximum Subarray
 *
 */
public class MaximumSubarray {

	/**
	 * @param args Given an integer array nums, find the contiguous subarray
	 *             (containing at least one number) which has the largest sum and
	 *             return its sum.
	 * 
	 *             Example:
	 * 
	 *             Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1]
	 *             has the largest sum = 6. Follow up:
	 * 
	 *             If you have figured out the O(n) solution, try coding another
	 *             solution using the divide and conquer approach, which is more
	 *             subtle.
	 */
	public static void main(String[] args) {
		MaximumSubarray m = new MaximumSubarray();
		int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(m.maxSubArray(nums));

	}
	
    public int maxSubArray2(int[] nums) {
    	if(nums == null) {
    		return 0;
    	}
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i =0; i < nums.length; i++) {
        	sum = Math.max(sum+nums[i], nums[i]);
        	max = Math.max(max, sum);
        }
        
        return max;
    }
    // nao funciona
    public int maxSubArray3(int[] nums) {
    	if(nums == null) {
    		return 0;
    	}
       return helperMaxSubArray(nums,0,nums.length-1,0);
    }

	private int helperMaxSubArray(int[] nums, int begin, int end, int sum) {
		if(end - begin < 1) {
			return nums[begin];
		}	
		int mid = (begin+end)/2;
		
		return 	 helperMaxSubArray(nums,begin,mid, sum)+
				helperMaxSubArray(nums,mid+1,end, sum);
	}
	
	public int maxSubArray(int[] A)
	{
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int n : A)
        {  
        	       	
        	// Se for menos que zero considera o valor que recebeu 
            if(sum < 0)
                sum = n;
            //Faz a soma do atual com o valor anterior
            else
                sum += n;
        //Atualiza o max caso a soma seja maior
            if(sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }

}
