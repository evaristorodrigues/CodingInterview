/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Evaristo 349. Intersection of Two Arrays
 */
public class IntersectionOfTwoArrays {

	/**
	 * @param args Given two arrays, write a function to compute their intersection.
	 * 
	 *             Example 1:
	 * 
	 *             Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2] Example 2:
	 * 
	 *             Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [9,4] Note:
	 * 
	 *             Each element in the result must be unique. The result can be in
	 *             any order.
	 * 
	 */
	public static void main(String[] args) {
		IntersectionOfTwoArrays i = new IntersectionOfTwoArrays();
        int[] nums2= {9,4,9,8,4};
		int[] nums1= {4,9,5};
		System.out.println(Arrays.toString(i.intersection(nums1, nums2)));		

	}
	
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] result = {};
        Set<Integer> values = new HashSet<>();
        Set<Integer> aux = new HashSet<>();
        
        for(int i =0; i < nums1.length; i++) {
        	values.add(nums1[i]);
        }
        
        for(int j = 0; j <nums2.length; j++ ) {
        	if(values.contains(nums2[j])) {
        		aux.add(nums2[j]);
        	}
        }
        result = new int[aux.size()];
        Iterator<Integer> iterator = aux.iterator();
        int i =0;
        while(iterator.hasNext()) {
        	Integer val = iterator.next();
        	result[i++] = val;
        }
        return result;
    }
    
    public int[] intersection3(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        set1.retainAll(set2);

        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
      }
    //FROM LEETCODE
    public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int [] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1)
          if (set2.contains(s)) output[idx++] = s;

        return Arrays.copyOf(output, idx);
      }
       //FROM LEETCODE
      public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        if (set1.size() < set2.size()) return set_intersection(set1, set2);
        else return set_intersection(set2, set1);
      }
	
}
