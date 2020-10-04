/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class StringCompression {

	/**
	 * @param args
	 */
	public String generateCompression(String s) {
	    // aaabbCC
		 //01234567
		//i= 123456
	    //count =12
		//prev =C
		//builder=3a2b2C
		if(s == null || s.length() ==0) {
			return s;
		}
	    int count =1;
	    char prev = s.charAt(0);
	    StringBuilder builder = new StringBuilder();
	    for( int i =1; i < s.length(); i++) {
	    	if(prev == s.charAt(i)) {
	    		count ++;
	    	}else {
	    		builder.append(count);
	    		builder.append(prev);
	    		count =1;
	    		prev= s.charAt(i);
	    	}
	    }
	    builder.append(count);
		builder.append(prev);
		
		if(builder.length() > s.length()) {
			return s;
		}else {
			return builder.toString();
		}
	}

	
	public static void main(String[] args) {
		StringCompression sc = new StringCompression();
		System.out.println(sc.generateCompression("evaristo"));
		System.out.println(sc.generateCompression("aaaaabbbbttkdeddffff"));
	}

}
