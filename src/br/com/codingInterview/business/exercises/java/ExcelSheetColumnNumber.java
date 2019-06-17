/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo
 *171. Excel Sheet Column Number
 */
public class ExcelSheetColumnNumber {

	/**
	 * @param args
	 * 
	 * 533

98

Favorite

Share
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
	 */
	public static void main(String[] args) {
		ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
        System.out.println(e.titleToNumber3("AAAA"));
        System.out.println(Math.pow(3, 0));
	}
	
    public int titleToNumber2(String s) {
    	if(s == null || s.length() == 0) {
    		return 0;
    	}
		//S[0] - 64 x 26 + (S[1] - 64)
    	switch (s.length()) {
		case 1:
			return s.toUpperCase().toCharArray()[0] - 64;	
		case 2:
			return (s.toUpperCase().toCharArray()[0] - 64) * 26 +(s.toUpperCase().toCharArray()[1] - 64);			
		case 3:	
			return ((s.toUpperCase().toCharArray()[0] - 64) * 26 +(s.toUpperCase().toCharArray()[2] - 64) )* 26 ;
		} 
    		
        return 0;
    }
    
    public int titleToNumber(String s) {
    	if(s == null | s.length() ==0) {
    		return 0;
    	}
    	int result =0;
    	int qtd = s.length();    	   	
    	for(int i = 0; i < qtd; i++) {
    		result=result *26 + (s.toUpperCase().charAt(i) - 'A' + 1);
    	}    		
        return result;
    }
    
    public int titleToNumber3(String s) {

        int ans = 0;
        int b = 0;
        
        for(int i=s.length()-1; i>=0; i--){
            int n = (int)s.charAt(i)-64 ;
            ans += n * Math.pow(26,b);
            b++;
        }
        
        return ans;
    }
	
	

}
