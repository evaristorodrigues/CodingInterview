/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class URLify {

	/**
	 * @param args
	 */
	
	public char[] replaceAllSpace(char[] chars, int charsLength) {
		if( chars == null || charsLength == 0) {
			return null;
		}
		int countSpaces=0;
		for( int i =0; i < charsLength; i++) {
			if( chars[i] == ' ') {
				countSpaces++;
			}
		}
		int index = charsLength + ( countSpaces * 2) -1;
		for(int i = 0 ; i < charsLength; i++) {
			if(chars[(charsLength - 1) - i] == ' ') {
				chars[index--] = '0';
				chars[index--] = '2';
				chars[index--] = '%';
			}else {
				chars[index--] = chars[(charsLength - 1) - i];
			}
		}
		
		return chars;
	}
	public static void main(String[] args) {
		URLify u = new URLify();
	
		System.out.println(u.replaceAllSpace("evar  isto    ".toCharArray(), 10));
		System.out.println(u.replaceAllSpace("evaristo".toCharArray(), 8));
		System.out.println(u.replaceAllSpace("evarist o  ".toCharArray(), 9));
		System.out.println(u.replaceAllSpace(" evaristo  ".toCharArray(), 9));
		

	}

}
