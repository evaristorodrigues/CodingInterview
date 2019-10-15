/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 *5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {

	/**
	 * 
	 */
	public LongestPalindromicSubstring() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestPalindromicSubstring lp = new LongestPalindromicSubstring();
		System.out.println(lp.longestPalindrome("atta"));

	}
	
    public String longestPalindrome2(String s) {
        if(s == null || s.length() ==0) {
        	return s;
        }        
        int start=0;
        int end=s.length()-1;
        int ls=0, le=0;
        while(start < s.length()-1) {
        	int current = start;
        	int currentEnd = end;
        	if(s.charAt(start) == s.charAt(end)) {
        		do {
        			current++;
        			currentEnd--;
        			if(s.charAt(current) != s.charAt(currentEnd)) {
        				break;
        			}else if(current == currentEnd || current > currentEnd){
        				if(le- ls < end -start) {
        					ls = start;
        					le = end;
        					end =0;
        					break;
        				}
        			}
        		}while(currentEnd >= current);
        	}
        	if(end -1 > start) {
        		end--;
        	}else {
        		start++;
        		end = s.length()-1;
        	}        	
        }        
        return s.substring(ls, le+1);
    }
    
    public String longestPalindrome(String s) {
        if(s == null || s.length() ==0) {
        	return s;
        } 
        int start=0, end =0;
      for( int i =0; i < s.length() ;i++) {
    	  
    	  int lenOdd =findPalindrome(s,i,i);
    	  int lenEven = findPalindrome(s,i,i+1);
    	  
    	  int length = Math.max(lenOdd, lenEven);
    	  
    	  if(length > end - start) {
    		  start = i -(length -1) / 2;
    		  end = i + length / 2;
    	  }
      }      
      return s.substring(start, end+1);
    }

	private int findPalindrome(String s, int left, int right) {
		while(left>=0 && right < s.length() && s.charAt(left)==s.charAt(right)) {
			left --;
			right++;
		}
		return right- left -1;
	}

}
