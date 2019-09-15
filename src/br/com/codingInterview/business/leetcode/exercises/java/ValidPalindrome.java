/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *125. Valid Palindrome
 */
public class ValidPalindrome {

	/**
	 * @param args
	 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
	 */
	public static void main(String[] args) {
		ValidPalindrome p = new ValidPalindrome();
		String s=",>";
		System.out.println(p.isPalindrome(s));
	}
    public boolean isPalindrome2(String s) {
        if(s.length() ==0) {
        	return true;
        }
        s= s.toLowerCase();
        s= s.replaceAll("[^a-zA-Z0-9]", "");
        int mid = (s.length() -1)/2;
        int left =s.length()%2==0?mid:mid-1;
        int right = mid+1;
        while(left >=0 && right <s.length()) {
        	if(s.charAt(left)!= s.charAt(right)) {
        		return false;
        	}
        	left--;
        	right++;
        }
        
        return true;
    }
    //A man, a plan, a canal: Panama
      
    public boolean isPalindrome3(String s) {
       if(s.isEmpty()) {
    	   return true;
       }
       s =s.toLowerCase();
       int head = 0; int tail = s.length()-1;
       while(head<tail) {
    	   if(!Character.isLetterOrDigit(s.charAt(head))) {
    		   head++;
    	   }else if(!Character.isLetterOrDigit(s.charAt(tail))){
    		   tail--;
    	   }else if(s.charAt(head)!=s.charAt(tail)) {
    		   return false;
    	   }else {
	    	   head++;
	    	   tail--;
    	   }
       }       
       return true;
    }
    
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) {
     	   return true;
        }
        s =s.toLowerCase();
        int head = 0; int tail = s.length()-1;
        while(head<tail) {
     	   while(!Character.isLetterOrDigit(s.charAt(head)) && head<tail) {
     		   head++;
     	   }
     	   while(!Character.isLetterOrDigit(s.charAt(tail))&& head<tail){
     		   tail--;
     	   }
     	   if(s.charAt(head)!=s.charAt(tail)) {
     		   return false;
     	   }     	   
 	    	   head++;
 	    	   tail--;
        }       
        return true;
     }

}
