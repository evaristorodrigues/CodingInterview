/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo 28. Implement strStr()
 */
public class ImplementStrStr {

	/**
	 * @param args Implement strStr().
	 * 
	 *             Return the index of the first occurrence of needle in haystack,
	 *             or -1 if needle is not part of haystack.
	 * 
	 *             Example 1:
	 * 
	 *             Input: haystack = "hello", needle = "ll" Output: 2 Example 2:
	 * 
	 *             Input: haystack = "aaaaa", needle = "bba" Output: -1
	 *             Clarification:
	 * 
	 *             What should we return when needle is an empty string? This is a
	 *             great question to ask during an interview.
	 * 
	 *             For the purpose of this problem, we will return 0 when needle is
	 *             an empty string. This is consistent to C's strstr() and Java's
	 *             indexOf().
	 */
	public static void main(String[] args) {
		ImplementStrStr i = new ImplementStrStr();
		System.out.println(i.strStr("aabaaabaaac", "aabaaac"));

	}
	
    public int strStr(String haystack, String needle) {
        int i =0;
        int j =0;
        int result = 0;
        if(haystack == null || needle == null ||
        		haystack.length()< needle.length()) {
        	return -1;
        }
        while(i < haystack.length() && j < needle.length()) {
        	if(haystack.charAt(i) == needle.charAt(j)) {
        		if(result == -1) {
        			result = i;
        		}
        		i++;
        		j++;
        	}else if(j > 0 && result > -1){
        		i=result+1;
        		result = -1;
        		j=0;          		
        	}else {
        		i++;
        		j=0;
        		result=-1;
        	}
        }
        if(result!=-1 && j != needle.length()) {
        	result = -1;
        }
        
        return result;
    }

}
