package br.com.codingInterview.business.exercises.java;

public class HouseRobber {

	public static void main(String[] args) {
		HouseRobber r = new  HouseRobber();
		int[] nums = {50, 1, 3, 9, 7, 2};
		System.out.println(r.rob2(nums));
	}
	
	public int rob(int[] nums) {
				
		if(nums == null || nums.length == 0) {
			return 0;
		}else if(nums.length == 1) {
			return nums[0];
		}else if(nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}else {
			int aux[] = new int[nums.length];
			aux[0]= nums[0];
			aux[1] =Math.max(nums[0], nums[1]);
			for(int i =2; i < nums.length ; i++) {
				aux[i] = Math.max(nums[i] + aux[i - 2], aux[i - 1]);
				
			}
			return aux[aux.length - 1];
		}
		
	}
	
	public int rob2(int[] nums) {
		int currentMax = 0;
		int prevMax = 0;
	
		for(int i=0; i < nums.length; i++ ) {
			int currentHouse =nums[i];
			int aux = Math.max(currentMax, currentHouse + prevMax);			
			prevMax= currentMax;
			currentMax = aux;
		}
		return currentMax;
	}

}
