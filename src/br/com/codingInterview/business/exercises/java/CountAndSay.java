/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

/**
 * @author Evaristo 38. Count and Say
 */
public class CountAndSay {

	/**
	 * @param args
	 * 
	 *             Share The count-and-say sequence is the sequence of integers with
	 *             the first five terms as following:
	 * 
	 *             1. 1 2. 11 3. 21 4. 1211 5. 111221 1 is read off as "one 1" or
	 *             11. 11 is read off as "two 1s" or 21. 21 is read off as "one 2,
	 *             then one 1" or 1211.
	 * 
	 *             Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the
	 *             count-and-say sequence.
	 * 
	 *             Note: Each term of the sequence of integers will be represented
	 *             as a string.
	 * 
	 * 
	 * 
	 *             Example 1:
	 * 
	 *             Input: 1 Output: "1" Example 2:
	 * 
	 *             Input: 4 Output: "1211"
	 */
	public static void main(String[] args) {
		CountAndSay c = new CountAndSay();
		int n =7;
		System.out.println(c.countAndSay(n));
	}
	
	public String countAndSay2(int n) {
		String result ="1";
		String aux = "1";
		String newValue="";
		int qtd =0;
		
		for(int i=1; i < n; i++) {
			for(int j =0; j < result.length(); j++) {
				String p = result.charAt(j)+"";
				if(!p.equals(aux)) {
					newValue+=qtd+aux;
					qtd=1;
					aux=p;
				}else {					
					qtd++;
				}				
			}
			newValue+=qtd+""+aux;
			result=newValue;
			qtd=0;
			newValue="";
			aux = result.charAt(0)+"";
		}
		return result;
	}
	
	public String countAndSay(int n) {
     String value = "1";
     StringBuilder newValue = new StringBuilder();
     for(int i = 1; i < n ;i++) {
    	 for(int j = 0,count=1; j <value.length(); j++) {
    		 if(j < value.length() - 1 && value.charAt(j) == value.charAt(j+1) ) {
    			 count++;
    		 }else {
    			 newValue.append(count);
    			 newValue.append(value.charAt(j));
    			 count=1;
    		 }
    	 }
    	 value = newValue.toString();
    	 newValue = new StringBuilder();
     }
     
     return value;
	}

}
