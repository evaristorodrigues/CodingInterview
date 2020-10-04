/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class IsUnique {

	
	public boolean isUnique(String s) {
		if(s == null || s.length()  == 0) {
			return true;
		}
		char c = s.charAt(0);
		for(int i =1; i < s.length(); i ++) {
			if(c != s.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IsUnique u = new IsUnique();
		System.out.println(u.isUnique("evaristo"));
		System.out.println(u.isUnique("aaaaa"));
		System.out.println(u.isUnique("aaaaaaab"));
		System.out.println(u.isUnique(""));
		System.out.println(u.isUnique("aaaaaaaa"));
		System.out.println(u.isUnique(null));
	}

}
