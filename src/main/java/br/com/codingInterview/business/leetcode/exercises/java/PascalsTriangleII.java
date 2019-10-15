/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Evaristo 119. Pascal's Triangle II
 */
public class PascalsTriangleII {

	/**
	 * @param args Given a non-negative index k where k ≤ 33, return the kth index
	 *             row of the Pascal's triangle.
	 * 
	 *             Note that the row index starts from 0.
	 * 
	 * 
	 *             In Pascal's triangle, each number is the sum of the two numbers
	 *             directly above it.
	 * 
	 *             Example:
	 * 
	 *             Input: 3 Output: [1,3,3,1] Follow up:
	 * 
	 *             Could you optimize your algorithm to use only O(k) extra space?
	 */
	public static void main(String[] args) {
		PascalsTriangleII p = new PascalsTriangleII();
		System.out.println(Arrays.toString(p.getRow(3).toArray()));
	}
	
    public List<Integer> getRow2(int rowIndex) {
    	List<Integer> prev = new ArrayList<>();    	
    	for(int i =0; i <= rowIndex; i++) {
    		List<Integer> row = new ArrayList<>();
    		for(int j = 0; j <= i; j++) {
    			if(j == 0 || j ==i) {
    				row.add(1);
    			}else {
    				row.add(prev.get(j-1)+prev.get(j));
    			}
    		}
    		prev = row;    		
    	}    	
    	return prev;
    }
    
    public List<Integer> getRow3(int rowIndex) {
    	List<Integer> result = new ArrayList<>();    	
    	for(int i =0; i <= rowIndex; i++) {
    		result.add(1);
    		for(int j= i-1; j > 0; j--) {
    		  result.set(j, result.get(j -1)+ result.get(j));
    		}               
    	}    	
    	return result;
    }

    public List<Integer> getRow(int rowIndex) {
    	Integer[] result =new Integer[rowIndex +1];    	
    	for(int i =0; i <= rowIndex; i++) {
    		result[i] =1;
    		for(int j= i-1; j > 0; j--) {
    		  result[j] = result[j -1]+ result[j];
    		}               
    	}    	
    	return Arrays.asList(result);
    }   
}
