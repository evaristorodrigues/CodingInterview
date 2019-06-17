package br.com.codingInterview.business.exercises.java;

import java.util.HashMap;
import java.util.Map;

/** 
 * 13. Roman to Integer
 * */
public class RomanToInteger {
	
	/**
	 * 
	 * @param args
	 * 
	 * 1Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
	 */
	public static void main(String[] args) {
		RomanToInteger r = new RomanToInteger();
		
		System.out.println(r.romanToInt("MMMCIV"));
	}
	/**
	ASC Symbol       Value
	73    I             1
	86    V             5
	88    X             10
	76    L             50
	67    C             100
	68    D             500
	77    M             1000
	
	I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.
	*/
    public int romanToInt2(String s) {
    	int result = 0;
    	for(int i = 0; i < s.length(); i++) {
    		switch (s.toUpperCase().charAt(i)) {
    		    //I
				case 73:
					result +=1;
					break;
		        //V
				case 86:
					if(i> 0 && s.toUpperCase().charAt(i -1) == 73) {
						result+=3;
					}else {
						result+=5;
					}
					break;
				//X	
				case 88:
					if(i> 0 && s.toUpperCase().charAt(i-1) == 73) {
						result+=8;
					}else {
						result+=10;
					}
					break;
				//L	
				case 76:
					if(i> 0 && s.toUpperCase().charAt(i-1) == 88) {
						result+=30;
					}else {
						result+=50;
					}
					
					break;
				//C	
				case 67:
					
					if(i> 0 && s.toUpperCase().charAt(i-1) == 88) {
						result+=80;
					}else {
						result+=100;
					}
					
					break;
			    //D		
				case 68:
					
				   if(i> 0 && s.toUpperCase().charAt(i-1) == 67) {
						result+=300;
					}else {
						result+=500;
					}
					
					break;	
				//M	
				case 77:
					   if(i> 0 && s.toUpperCase().charAt(i-1) == 67) {
							result+=800;
						}else {
							result+=1000;
						}
					
					break;

			}
    	}
    	
        return result;
    }
    
	public int romanToInt(String s) {
		int result =0;
		int prev=0;
    	Map<Character, Integer> map = new HashMap<>();
    	map.put('I',1);
    	map.put('I',1);
    	map.put('V',5);
    	map.put('X',10);
    	map.put('L',50);
    	map.put('C',100);
    	map.put('D',500);
    	map.put('M',1000);
    	
    	for(int i = s.length()-1; i >= 0; i--) {
    		char key = s.toUpperCase().charAt(i);
    		if(map.get(key) >= prev) {
    			result+=map.get(key);    			
    		}else {
    			result-=map.get(key);
    		}
    		prev =map.get(key);
    	}
    	return result;
    }
    

	

}
