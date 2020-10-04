/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author evaristosrodrigues
 *22. Generate Parentheses
 */
public class GenerateParentheses {

	/**
	 * @param args
	 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
	 */
	public static void main(String[] args) {
		GenerateParentheses generateParentheses = new GenerateParentheses();
		System.out.println(Arrays.toString(generateParentheses.generateParenthesis(3).toArray()));

	}
    //Brute Force
    public List<String> generateParenthesis2(int n) {
    	
    	List<String> result = new ArrayList<String>();
    	if( n <=0) {
    		return result;
    	}
    	helper(new char[2*n],0,result);
    	return result;
        
    }

	private void helper(char[] cs, int pos, List<String> result) {
        if(pos == cs.length) {
        	if(isValidParenthesis(cs)) {
        		result.add(new String(cs));
        	}
        }else {
        	cs[pos] ='(';
        	helper(cs, pos+1, result);
        	cs[pos] =')';
        	helper(cs, pos+1, result);
        }
	}

	private boolean isValidParenthesis(char[] cs) {
	 int p = 0;
	 for( int i =0; i < cs.length; i++) {
		 if(cs[i] == '(') {
			 p++;
		 }else {
			 p--;
			 if(p < 0) {
				 return false;
			 }
		 }
	 }	 
	 return p == 0;
	}
	
    //Intuitivo
    public List<String> generateParenthesis(int n) {
    	
    	List<String> result = new ArrayList<String>();
    	if( n <=0) {
    		return result;
    	}
    	helper(n,"",0,0,result);
    	return result;
        
    }
	private void helper(int n, String current, int open, int close, List<String> result) {
		if(current.length() == n*2) {
			result.add(current);
			return;
		}
		
		if( open < n) {
			helper(n, current+"(", open+1, close, result);
 		}
		if(close < open) {
			helper(n, current+")", open, close+1, result);
		}
	}		
}
