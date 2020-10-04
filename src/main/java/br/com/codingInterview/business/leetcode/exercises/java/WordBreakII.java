/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author evaristosrodrigues
 *
 */
public class WordBreakII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "pineapplepenapple";
		String[] values = {"apple","pen","applepen","pine","pineapple"};
		WordBreakII b = new WordBreakII();
		System.out.println(Arrays.toString(b.wordBreak(s, Arrays.asList(values)).toArray()));

	}

	
    public List<String> wordBreak(String s, List<String> wordDict) {
    	
    	if( !canBreak(s, wordDict))
    		return new ArrayList<String>();
        //Map<Integer, List<String>> senteceMap = new HashMap<>();
    	StringBuilder[] sentences = new StringBuilder[s.length()];
    	Set<String> wordDictSet = new HashSet<String>(wordDict);
        
        for( int i = 1; i <= s.length(); i++) {
        	for(int j =0; j <i;j++ ) {
        		
        		String value = s.substring(j, i);  
        		
        		if(j==0  && wordDictSet.contains(value)) {
        			
        			//List<String> words = new ArrayList<String>();
        			//words.add(value);
        			//senteceMap.put(i-1, words);
        			sentences[i-1] = new StringBuilder();
        			sentences[i-1].append(value).append(",");
        			
        		//}else if((senteceMap.get(j - 1) != null) && wordDictSet.contains(value)) {
            	}else if(j - 1 >=0 && (sentences[j - 1] != null) && wordDictSet.contains(value)) {

        			
        			//List<String> words = senteceMap.get(j -1);
        			//List<String> newWords = senteceMap.getOrDefault(i-1, new ArrayList<String>());
            		
            		StringBuilder array = sentences[j-1];
        			
        			//for(String word: words) {
        			//	newWords.add(word + " "+value);
        		//	}
        		//	senteceMap.put(i-1, newWords);   
            		if(sentences[i-1] == null) {
            			sentences[i-1] = new StringBuilder();
            		}
            		for(String word : array.toString().split(",")) {
            				sentences[i-1].append(word).append(" ").append(value).append(",");            				
            		}
        		}            		
        	}
        }
        
    	return Arrays.asList(sentences[s.length()-1].toString().split(",")) ; 
    }
    

    public boolean canBreak(String s, List<String> wordDict) {
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
    	
}
