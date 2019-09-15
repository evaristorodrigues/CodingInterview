/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Evaristo
 *3. Longest Substring Without Repeating Characters
 */
public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * 
	 */
	public LongestSubstringWithoutRepeatingCharacters() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
	    System.out.println(l.lengthOfLongestSubstring("abacabacbb"));			

	}
	//my
    public int lengthOfLongestSubstring2(String s) {
        if(s==null || s.length() ==0) {
        	return 0;
        }
        int result=0;
        Set<Character> set = new HashSet<Character>();
        set.add(s.charAt(0));
        int qtd =1;
        int begin =0;
        int end = begin +1;
        //abcabcbb
        while(end <s.length()) {
        	char v = s.charAt(end);
        	if(set.contains(v)) {
        		if(result < qtd) {
        			result= qtd;       			
        		}
       			qtd=1;
    			begin++;// or indexOf(v)+1;
    			end=begin+1;
    			set.clear();
    			set.add(s.charAt(begin));          		
        	}else {
        		qtd++;
        		end++;
        		set.add(v);
        	}
        }
        if(result < qtd) {
        	result = qtd;
        }
       return result; 
    }
    
    public int lengthOfLongestSubstring4(String s) {
        if(s==null || s.length() ==0) {
        	return 0;
        }
        int begin=0;
        int end =0;
        int result =0;
        Set<Character> characters = new HashSet<Character>();
        while(end < s.length()) {
        	if(characters.contains(s.charAt(end))) {
        		characters.remove(s.charAt(begin++));
        	}else {
        		characters.add(s.charAt(end));
        		end++;
        		if(result < characters.size()) {
        			result = characters.size();
        		}
        		
        	}
        }

       return result; 
    }
    //COm mais votos
    public int lengthOfLongestSubstring3(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
    //Considerando a posicao
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> indices = new HashMap<Character,Integer>();
        int length = 0;
        int start = 0;
        int end = 0;
        for(end=0; end < s.length(); end++){
            char c = s.charAt(end);
            if(indices.containsKey(c)){
                int newstart = indices.get(c)+1;
                start = Math.max(start,newstart);
            }
            length = Math.max(length,(end-start)+1);
            indices.put(c,end);
        }
        return length;
    }


}
