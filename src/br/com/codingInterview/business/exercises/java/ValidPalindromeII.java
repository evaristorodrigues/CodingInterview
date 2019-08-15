/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo
 *680. Valid Palindrome II
 */
public class ValidPalindromeII {

	/**
	 * @param args
	 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
	 */
	public static void main(String[] args) {
		ValidPalindromeII v = new ValidPalindromeII();
		String s="1221aa";
		System.out.println(v.validPalindrome(s));
	}
	
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {        	
        	if(s.charAt(left) != s.charAt(right)) {
        		return isValid(s,left+1, right ) || isValid(s, left, right-1);
        	}
        	left ++;
        	right--;
        }
        return true;        
    }

	private boolean isValid(String s, int left, int right) {
		while(left<right) {
			if(s.charAt(left)!= s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}  
    

}
