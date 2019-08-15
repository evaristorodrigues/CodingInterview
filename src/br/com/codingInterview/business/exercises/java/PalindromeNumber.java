/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evaristo
 *9. Palindrome Number
 */
public class PalindromeNumber {

	/**
	 * @param args
	 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
	 */
	public static void main(String[] args) {
		PalindromeNumber p = new PalindromeNumber();
		System.out.println(p.isPalindrome(121));
	}
    public boolean isPalindrome2(int x) {
       List<Integer> values = new ArrayList<Integer>();
       if(x < 0) {
    	   return false;
       }      
       while(x > 0) {
    	   values.add(x % 10);
    	   x/=10;
       }       
       int left=0;
       int right= values.size()-1;       
       while(left< right) {
    	   if(!values.get(left).equals(values.get(right))){
    		   return false;
    	   }
    	   left++;
    	   right--;
       }
    	return true;
    }
    
    public boolean isPalindrome(int x) {
        if(x < 0 || x % 10 ==0 && x!=0) {
     	   return false;
        }  
        //Crio o reverse para pegar o numero pela metade e invertido
        int reverse=0;
        while(x > reverse) {
        	//deixo o numero a contrario, multiplo por 10 para ir movendo pra a esquerda
        	reverse = (reverse * 10) + (x%10);
        	x/=10;
        }
        //devido ao fato de termos pares (even) e impares(odd)
     	return x == reverse || x == (reverse/10);
     }

}
