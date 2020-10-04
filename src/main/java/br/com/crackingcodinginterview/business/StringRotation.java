/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class StringRotation {

	/**
	 * @param args
	 */
	
	public boolean isRotation(String s1, String s2){
		if(s1 == null || s2 == null 
				|| s1.length() != s2.length()) {
			return false;
		}
		if(s1.length() == 0) {
			return true;
		}
		 
		for(int i = 0; i < s1.length(); i++) {
            int pos =0;
            int posRotate =i;
            while(  pos < s1.length() && s1.charAt(pos) ==s2.charAt(posRotate%(s1.length()))) {
            	pos++;
            	posRotate ++;
            }
			if(pos == s1.length() ) {
				return true;
			}			
		}		
		return false;
	}
	public boolean isRotation2( String s1, String s2) {
		if(s1 == null || s2 == null 
				|| s1.length() != s2.length()) {
			return false;
		}
		if(s1.length() == 0) {
			return true;
		}		
		String word= s1 + s1;
		
		for( int i =0; i < word.length() / 2; i++) {
			String sub = word.substring(i, i + s2.length());
	        if(sub.equals(s2)) {
	        	return true;
	        }		
		}
		return false;
	}

	
	public boolean isRotation3( String s1, String s2) {
		if(s1 == null || s2 == null 
				|| s1.length() != s2.length()) {
			return false;
		}
		if(s1.length() == 0) {
			return true;
		}		

		for( int i =0; i < s1.length(); i++) {
			StringBuilder sub =new StringBuilder();
			sub.append(s1.substring(i));
			sub.append(s1.substring(0,i));
	        if(sub.toString().equals(s2)) {
	        	return true;
	        }		
		}
		return false;
	}

	
	public static void main(String[] args) {
		StringRotation sr = new StringRotation();
		System.out.println(sr.isRotation3("aaaaaaab", "aaabaaaa"));

	}

}
