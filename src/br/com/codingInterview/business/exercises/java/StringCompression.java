/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.Arrays;

/**
 * @author Evaristo 443. String Compression
 */
public class StringCompression {

	/**
	 * @param args Given an array of characters, compress it in-place.
	 * 
	 *             The length after compression must always be smaller than or equal
	 *             to the original array.
	 * 
	 *             Every element of the array should be a character (not int) of
	 *             length 1.
	 * 
	 *             After you are done modifying the input array in-place, return the
	 *             new length of the array.
	 * 
	 * 
	 *             Follow up: Could you solve it using only O(1) extra space?
	 * 
	 * 
	 *             Example 1:
	 * 
	 *             Input: ["a","a","b","b","c","c","c"]
	 * 
	 *             Output: Return 6, and the first 6 characters of the input array
	 *             should be: ["a","2","b","2","c","3"]
	 * 
	 *             Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2".
	 *             "ccc" is replaced by "c3".
	 * 
	 * 
	 *             Example 2:
	 * 
	 *             Input: ["a"]
	 * 
	 *             Output: Return 1, and the first 1 characters of the input array
	 *             should be: ["a"]
	 * 
	 *             Explanation: Nothing is replaced.
	 * 
	 * 
	 *             Example 3:
	 * 
	 *             Input: ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
	 * 
	 *             Output: Return 4, and the first 4 characters of the input array
	 *             should be: ["a","b","1","2"].
	 * 
	 *             Explanation: Since the character "a" does not repeat, it is not
	 *             compressed. "bbbbbbbbbbbb" is replaced by "b12". Notice each
	 *             digit has it's own entry in the array.
	 * 
	 * 
	 *             Note:
	 * 
	 *             All characters have an ASCII value in [35, 126]. 1 <= len(chars)
	 *             <= 1000.
	 * 
	 */
	public static void main(String[] args) {
		StringCompression s = new StringCompression();
		char[] chars ={'\\','\\','\\','\\','\\','\\','\\','\\','\\','\\', 'p','p'} ;//{'t','L','L','L','[','t','t','t','v','j','j','h','{','{','E','l','l','~','~','l','\\','\\','\\','\\','\\','\\','\\','\\','\\','\\','3','1','>','>','r','r','l','K','K','K','j','j','n','n','.','V','9','9','9','g','4','b','b','b','b','v','v','v','D','{','4','R','R','R','[','D','D','D','D','D','{','{','M','M','c','c','c','c','N','y','y','=','=','m','7','7','7','7','*','*','f','f','f','f','f','5','K','K','@','b','(','(','(','`','h','h','K','Y','M','M','-','-','2','2','K','.','F','F','F','w','w','R','p','p','H','R','u','u','W','R','~','#','T','T','T','T','C','C','u','H','H','4','I','\\','\\','\\','\\','b','b','h','S','S','(','(',']',']','(','(','J','J','J','U','U','U','U','J','J','}','x','s','s','a','a','@','>','~','~','~','Z','A','A','t','G','-','o','V','V','7','7','q','q','q','q','q','|','j','j','I','D','}','}','}','}','&','M','M',')','(','(','(','#','c','c','c','c','c','c','c','c','j','b','0','8','8','8','p','\\','\\','t','a','a','=','=','v','M','2','2','2','=','=','=','=','=','=','=','=','=','J','J','8','8','8','c','|','D','r','3','3','1','1','1','Q','Q','Q','Q','Q','J','J','J','J','a','v','O','+','+','+','+','2','2','2','i','I','I','I','&','h','h','L','U','B','e','.','.','.','x','x','x','x','G',';'};
		System.out.println(s.compress(chars ));
		System.out.println(Arrays.toString(chars));
	}

    public int compress(char[] chars) {
    	if(chars == null || chars.length ==0) {
    		return 0;
    	}
    	int newLength=0;
    	int qtdValue=1;
    	int pos=0;
    	for(int i =0; i < chars.length; i++) {
        	if(i < chars.length - 1 && chars[i] == chars[i+1]) {
        		qtdValue++;
        	}else {	
                  if(qtdValue > 1) {
                	  if(qtdValue < 10) {
                    	  chars[pos++]=chars[i];
                    	  chars[pos++] = (char)(qtdValue+'0');
                    	  qtdValue=1;
                    	  newLength+=2;                		  
                	  }else {
                		  chars[pos++]=chars[i];
                		  newLength++;
                		  String v = String.valueOf(qtdValue);
                		  for(int k =0; k < v.length(); k++) {
                			  chars[pos++] = v.charAt(k);
                			  newLength++;
                		  }
                		  qtdValue=1;
                	  }
                  }else {
                	  chars[pos++]=chars[i];
                	  qtdValue=1;
                	  newLength++;
                  }
        	}
        }
        
        return newLength;
    }
}
