/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Evaristo
 *118. Pascal's Triangle
 */
public class PascalsTriangle {

	/**
	 * @param args
	 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
	 */
	public static void main(String[] args) {
		PascalsTriangle p = new  PascalsTriangle();
        System.out.println(Arrays.toString(p.generate(5).toArray()));
	}

    public List<List<Integer>> generate2(int numRows) {
    	List<List<Integer>> pascal = new ArrayList<List<Integer>>();
    	if(numRows < 1) {
    		return pascal;
    	}
    	List<Integer> element = new ArrayList<>();
    	element.add(1);
    	pascal.add(element);
    	if(numRows == 1) {
    		return pascal;
    	}
    	element = new ArrayList<>();
    	element.add(1);
    	element.add(1);
    	pascal.add(element);
    	if(numRows ==2) {
    		return pascal;
    	}
    	int seq =1;
    	for(int i =2; i < numRows; i++) {
    		element = new ArrayList<Integer>();
    		element.add(1);
    		List<Integer> numeros = pascal.get(seq++);
    		for(int j =0; j < (numeros.size() - 1); j++) {
    			element.add(numeros.get(j)+numeros.get(j+1));
    		}
    		element.add(1);
    		pascal.add(element);
    	}
    	
    	return pascal;
        
    }
    
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> pascal = new ArrayList<List<Integer>>();
    	if(numRows < 1) {
    		return pascal;
    	}
    	for(int i =0; i < numRows; i++) {
    		List<Integer> element = new ArrayList<Integer>();
    		for(int j =0; j<=i; j++) {
    			if(j ==0 || j ==i) {
    				element.add(1);
    			}else {
    				element.add(pascal.get(i-1).get(j-1)+pascal.get(i-1).get(j));    				
    			}
    		}
    		pascal.add(element);
    	}
    	
    	return pascal;
        
    }
}
