/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class OneWay {

	/**
	 * @param args
	 */
	public boolean validate(String a, String b) {
		if( a == null && b == null) {
			return true;
		}else if( a== null || b== null) {
			return false;
		}
		int lengthDiff = a.length() - b.length();
		if( lengthDiff > 1 || lengthDiff < -1) {
			return false;
		}		
		int pa=0;
		int pb=0;
		boolean foundDiff = false;
		// pale tt
		while( pa < a.length() && pb < b.length()){
			if(a.charAt(pa) != b.charAt(pb)) {
				if(foundDiff) {
					return false;
				}
				foundDiff = true;
				if(a.length() == b.length()) {
					pa++;
					pb++;
				}else if( a.length() > b.length()) {
					pa++;
				}else {
					pb++;
				}
				
			}else {
				pa++;
				pb++;
			}		
		}
     return true;
	}
	
	public static void main(String[] args) {
		OneWay ow = new OneWay();
		System.out.println(ow.validate("pales", "pale"));
		System.out.println(ow.validate("pale", "ale"));
		System.out.println(ow.validate("ales", "pale"));
		System.out.println(ow.validate("pale", "bale"));
		System.out.println(ow.validate("pale", "bake"));
		System.out.println(ow.validate("pale", "pa"));
		System.out.println(ow.validate("pale", "pelss"));

	}

}
