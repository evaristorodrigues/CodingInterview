/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author Evaristo
 *20. Valid Parentheses
 */
public class ValidParentheses {

	/**
	 * @param args
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
	 */
	public static void main(String[] args) {
      ValidParentheses vp = new ValidParentheses();      
      System.out.println(vp.isValid("([])[]}"));
	}
	
    public boolean isValid2(String s) {
    	
    	Map<Character, Character> parentheses = new HashMap<Character, Character>();
    	List<Character> ends = new ArrayList<Character>();
    	
    	
    	parentheses.put('(', ')');
    	parentheses.put('{', '}');
    	parentheses.put('[', ']');    	

        for(int i =0; i < s.length(); i++) {
        	char value = s.charAt(i);
        	if(parentheses.containsKey(value)) {
        		ends.add(parentheses.get(value));
        	}else if(ends.size() >0 && ends.get(ends.size() -1).equals(value)) {
        		ends.remove(ends.size() -1);
        	}else {
        		return false;
        	}
        }    
        if(ends.size() > 0) {
        	return false;
        }
        return true;
    }
    
    public boolean isValid(String s) {
    	
    	Stack<Character> ends = new Stack<Character>();

        for(int i =0; i < s.length(); i++) {
        	char value = s.charAt(i);
        	if('('== value) {
        		ends.push(')');
        	}else if('{' == value) {
        		ends.push('}');
        	}else if('[' == value) {
        		ends.push(']');
        	}else if(ends.isEmpty() || ends.pop() != value) {
        	   return false;
        	}        	
        }
      return ends.isEmpty();    
   }
}
