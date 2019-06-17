/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo
 *
 */
public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseString r = new ReverseString();
		char[] c =  {'s','o','l','l','e','h'};
        r.reverseString3(c);
        System.out.println(c);
	}
	
    public void reverseString(char[] s) {
    	char aux;
    	int last =s.length - 1;
        for(int i =0; i < s.length/2; i ++) {
        	aux =s[i];
        	s[i] = s[last -i];
        	s[last -i] = aux;
        }
    }
    
    public void reverseString2(char[] s) {
    	char aux;
        for(int i =0; i < s.length/2; i ++) {
        	aux =s[i];
        	s[i] = s[(s.length - 1) -i];
        	s[(s.length - 1) -i] = aux;
        }
    }
    
    public void reverseString3(char[] s) {
        for(int i =0; i < s.length/2; i ++) {
             s[i] = (char) (s[i] + s[(s.length -1) - i]);
             s[(s.length -1) - i] = (char) (s[i] -s[(s.length -1) - i]);
             s[i] = (char) (s[i] - s[(s.length -1) - i]);             
        }
    }

}
