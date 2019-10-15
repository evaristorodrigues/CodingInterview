/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.lang.reflect.Array;

/**
 * @author Evaristo
 *14. Longest Common Prefix
 */
public class LongestCommonPrefix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		
		String[] array = {"flower", "flow","flight"};
		System.out.println(lcp.longestCommonPrefix(array));

	}
	
    public String longestCommonPrefix2(String[] array) {
    	if(array == null || array.length ==0) {
    	  return "";	
    	}    	
    	String prev =array[0];
    	for(int i =1; i< array.length; i++) {        		
    		String current = "";
    		for(int pos =0; pos < prev.length() && pos <array[i].length(); pos++) {
    			if(prev.charAt(pos) == array[i].charAt(pos)) {
    			  current+=prev.charAt(pos);
    			} else {
    				break;
    			}
    		}
    		prev = current;   		
    	}    	
        return prev;
    }
    
    public String longestCommonPrefix1(String[] array) {
    	if(array == null || array.length ==0) {
    	  return "";	
    	}    	
    	String prev =array[0];
    	for(int i =1; i< array.length; i++) {        		
   		      while(array[i].indexOf(prev) !=0) {	
   		    	  prev = prev.substring(0, prev.length() - 1);
   		    	  if(prev.isEmpty()) {
   		    		  return "";
   		    	  }
   		      }
    	}    	
        return prev;
    }
    
    public String longestCommonPrefix3(String[] array) {
    	if(array == null || array.length ==0) {
    	  return "";	
    	}    	

    	for(int i =0; i< array[0].length(); i++) {        		
            char c =  array[0].charAt(i);    		
            for( int j = 1; j < array.length; j++) {
            	if(i == array[j].length() || c!= array[j].charAt(i)) {
            		return  array[0].substring(0,i);
            	}
            }
    	}     	
    	return array[0];
    }
    //divide and conquer
    public String longestCommonPrefix(String[] array) {
    	if(array == null || array.length ==0) {
    	  return "";	
    	}      	
    	return helperCommonPrefix(array, 0, array.length-1); 
    }

	private String helperCommonPrefix(String[] array, int begin, int end) {
		if(begin == end) {
			return array[begin];
		}
		int mid = (end + begin) / 2;
		String left = helperCommonPrefix(array, begin, mid);
		String right =  helperCommonPrefix(array, mid +1, end);		
		return helperPrefix(left, right);
		
	}

	private String helperPrefix(String left, String right) {
		int min =Math.min(left.length(), right.length());		
		for (int i = 0; i < min; i++) {
			if(left.charAt(i) != right.charAt(i)) {
				return left.substring(0, i);
			}
		}		
		return left.substring(0, min);
	}

}
