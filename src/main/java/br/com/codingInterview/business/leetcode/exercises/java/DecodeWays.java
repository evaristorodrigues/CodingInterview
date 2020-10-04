/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author evaristosrodrigues
 *91. Decode Ways
 */
public class DecodeWays {
/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */

	public static void main(String[] args) {
		DecodeWays d = new DecodeWays();
		System.out.println(d.numDecodings("062626"));
	}
	
    public int numDecodings2(String s) {
         if( s == null) {
        	 return 0;
         }
         Integer[] memo = new Integer[ s.length()+1];
         return  helper(s, s.length(),memo);
    }

	private int helper(String data, int k,Integer[] memo) {
        if(k == 0) {
        	return 1;
        }
		String value = data.substring(data.length()-k,(data.length()-k) +1 );
		if(value.equals("0")) {
			return 0;
		}
		if(memo[k]!= null) {
			return memo[k];
		}
		int result = helper(data,k -1, memo);
		
		if(k>=2 && Integer.parseInt(data.substring(data.length()-k, data.length()-k +2)) <=26) {
		  result +=helper(data,k-2, memo);
		}
		memo[k] = result;
		return result;
	}
	
	//using DP 262626
    //         012345
    public int numDecodings(String s) {
    	if( s == null || s.length() == 0) {
    		return 0;
    	}
	    int[] dp = new int[s.length()+1];
	    dp[0]=1;
	    dp[1]=s.charAt(0)!='0'?1:0;
	    
	    for( int i =2; i <= s.length(); i++) {
	    	int oneChar = Integer.parseInt(s.substring(i-2,i));
	    	int second = Integer.parseInt(s.substring(i-1,i));
	    	
	    	if(oneChar >=10 &&  oneChar<=26) {
	    		dp[i] += dp[i-2];
	    	}
	    	if( second > 0) {
	    		dp[i]+=dp[i-1];
	    	}
	    }
    	return dp[s.length()];
   }
}
