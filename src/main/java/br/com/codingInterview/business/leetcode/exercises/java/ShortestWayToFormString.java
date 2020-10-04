/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author evaristosrodrigues
 *
 */
public class ShortestWayToFormString {

	/**
	 * @param args
	 */
	
	public int shortestWay(String source, String target) {
		int ways =0;
		if( target == null || source == null) {
			return 0;
		}
		String s = new String(target);
		StringBuilder sub = new StringBuilder();
		int pt =0;
		while(pt < s.length()) {
			
			for( int i =0; i < source.length(); i++) {
			    if(source.charAt(i) == s.charAt(pt) ) {
			    	sub.append(s.charAt(pt));
			    	pt++;
			    	
			    }
			}
			if(sub.length() > 0) {
				ways++;				
				s = s.substring(sub.length());
				sub = new StringBuilder();
				pt=0;
			}else {
				return -1;
			}			
		}		
		return ways;
	}
	public static void main(String[] args) {
		System.out.println(new ShortestWayToFormString().shortestWay("ab","aaaa"));

	}

}
