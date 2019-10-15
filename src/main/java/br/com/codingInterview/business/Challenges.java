/**
 * 
 */
package br.com.codingInterview.business;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Evaristo
 *
 */
public class Challenges {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//compareCommonItem 
/*       String[] a = {"a","b","k","f"};
	   String[] b = {"x","j","c","d","e","f"};	   
	   System.out.println(compareCommonItem(a, b));
	   */
	   
		//int[] array = {1,0,8,0,5,3,5};
		//int[] v = twoSum(array, 10);
		//System.out.println(v[0]);
		//System.out.println(v[1]);
	    //hasPairWithSum(array, 10);
		//int array[] ={2,3,4,5}; //{2,1,1,2,3,5,1,2,4}; // {2,5,1,2,3,5,2,4};
	    //System.out.println(recurringCharacter(array));
		
		String[] basket = {"2","65","34","2","1","7","8"};
			
		Arrays.sort(basket);
		
		for(int i = 0; i < basket.length; i++) {
			
			System.out.println(basket[i]);
		}
		
		
/*		int[] array = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(maxSubArray(array));*/
	}
	
	private static Integer  recurringCharacter(int[] array) {
		if(array == null) {
			return null;
		}
		
		if(array.length < 2) {
			return null;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i =0; i < array.length; i++) {
			
			if(map.containsKey(array[i])) {
				return array[i];
			}else {
				map.put(array[i], i);
			}
		}
		
		return null;
		
	}

	public static boolean compareCommonItem(String[] array1, String[] array2) {
	   //0(n^2) = O(a*b)
		//O(1) Space Complexity
/*	   for(int i =0; i < a.length; i++) {		   
		   for( int j = 0; j < b.length; j++) {			   
			   if(a[i].equals(b.clone()[j])) {
				   System.out.println("Valor de A = "+a[i] + " Valor de B = "+b[j]);
				  return true;
				   
			   }
			   
		   }
	   }*/	   
	   
		//O(a+b) Time Complexity
		//O(a) Space Complexity
    Map<String, Boolean> mapArray = new HashMap<String, Boolean>();		
	for(int i =0; i < array1.length; i++)	{
		if(!mapArray.containsKey(array1[i])) {
			mapArray.put(array1[i], true);
		}
	}
	
	for(int j = 0; j < array2.length; j++) {
		Boolean value = mapArray.get(array2[j]);
		if( value != null) {
			 System.out.println("Valor de A = "+value+ " Valor de B = "+array2[j]);
			 return true;
		}
	}
	   return false;
		
		
	}
	
	public static boolean hasPairWithSum(Integer[] array, Integer total) {
		
		//O(n^2) Time Complexity
		//O(1) Space Complexity
/*		for(int i=0; i < array.length; i ++) {			
			for( int j = i+1; j < array.length; j ++) {
				if((array[i] + array[j]) == total) {
					System.out.println("A Soma dos dois"+array[i] +" + " + array[j]+" dão = "+total);
					//return true;
				}
			}
		}*/
		
		//O(n) Time Complexity
		//O(array) Space Complecity
		Set<Integer> values = new HashSet<Integer>();
		for(int i=0; i < array.length; i ++) {
			if(values.contains(total - array[i] )) {
				System.out.println("A Soma dos dois"+array[i] +" + " +( total - array[i] )+" dão = "+total);

				//return true;
			}else {
		       values.add(array[i]);
			}
		}
		
		

		return false;
	}
	
	
	public static int maxSubArray(int[] A) {
	    int maxSoFar=A[0], maxEndingHere=A[0];
	    for (int i=1;i<A.length;++i){
	    	maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
	    	maxSoFar=Math.max(maxSoFar, maxEndingHere);	
	    }
	    return maxSoFar;
	}
	
	 public static int[] twoSum(int[] nums, int target) {
	        
	        int[] result = new int[2];
	        
	        Map<Integer, Integer> values = new HashMap<Integer, Integer>();
	        
	        for(int i = 0; i < nums.length ; i++ ){
	            
	            if(values.containsKey(target - nums[i])){
	                result[0] =  values.get(target - nums[i]);
	                result[1] = i;             
	                
	            }else {	            	
	            	values.put(nums[i], i);
	            }
	        }
	        
	        return result;       
	 }
}
