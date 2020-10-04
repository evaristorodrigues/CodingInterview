/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author evaristosrodrigues
 *
 */
public class WordBreak {

	/**
	 * 
	 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
	 */
	public static void main(String[] args) {
		String s = "applepenapple";
		String[] values = {"apple", "pen"};
		WordBreak b = new WordBreak();
		System.out.println(b.wordBreak(s, Arrays.asList(values)));

	}      
	
    public boolean wordBreakDP(String s, List<String> wordDict) {
    	//validate
        if(wordDict == null || wordDict.size() ==0 || s == null || s.length() == 0) {
        	return false;
        }
        //create a boolean to be part of DP
        boolean[] pieces = new boolean[s.length()];
        //Create a Set so use contains
        Set<String> wordDictSet = new HashSet<String>(wordDict);
        //Iterate all character
        for( int i =1; i <= s.length(); i++) {
        	//Iterate all character from left to i
        	for( int j=0; j <=i ; j++) {
        		String piece =s.substring(j, i);
        		if((j ==0 || pieces[j-1]) && wordDictSet.contains(piece)) {
        			pieces[i-1] = true;
        			break;
        		}
        	}
        }
        return pieces[s.length()-1];
    }
    
    //FIXME Better STUDY
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length()];
        return wordBreak(s,0,wordDict,visited);
    }
    private boolean wordBreak(String s, int startIndex, List<String> wordDict, boolean[] visited){
        if(startIndex == s.length()) return true;
       // if(visited[startIndex]) return false;
        visited[startIndex] = true;
        for(String word:wordDict){
            if(s.startsWith(word,startIndex)){
                if(wordBreak(s, startIndex+word.length(), wordDict, visited)) return true;
            }
        }
        return false;
    }


}
