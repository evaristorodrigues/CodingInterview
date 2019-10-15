/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;




/**
 * @author Evaristo
 *
 */
public class BAFO {

	/**
	 * 
	 */
	public BAFO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String linha = null;
			try {
		    int count = 0;
		    int b=0;
		    int a = 0;
		    int qtd=0;
		    StringBuilder resultado = new StringBuilder();
			while((linha = reader.readLine()) != null) {
				if(linha.length() == 1) {
					if(count > 0) {
						if(a > b) {
							resultado.append("\nAldo ");
						}else {
							resultado.append("\nBeto ");
						}
						resultado.append("\n\n");
					}
					if(linha.equals("0") ) {
						System.out.println(resultado.toString());
						return;
					}
					qtd = Integer.parseInt(linha);
				 	count++;			 	
				 	resultado.append("Teste ");
				 	resultado.append(count);
					b =0;
					a = 0;
				}else {
					String[] values = linha.split(" ");
					a += Integer.parseInt(values[0]);
					b += Integer.parseInt(values[1]);
				}			
			}
			}catch(Exception e){
				System.out.println(e);
			}

	}

}
