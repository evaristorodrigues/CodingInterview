package br.com.codingInterview.business.datastructure.java;

class Node {
	int elements = 0;
	Node[] characters = new Node[26];
}

public class Trie {
	Node root;

	public Trie() {
		this.root = new Node();
	}

	public int query(String s) {
		Node current = root;
		for (int i = 0; i < s.length(); i++) {
			if (current.characters[s.charAt(i) - 'a'] == null) {
				return 0;
			} else {
				current = current.characters[s.charAt(i) - 'a'];
			}
		}
		return current.elements;
	}

	public void insert(String s) {
		Node current = root;
		for (int i = 0; i < s.length(); i++) {
			if (current.characters[s.charAt(i) - 'a'] == null) {
				Node node = new Node();
				current.characters[s.charAt(i) - 'a'] = node;
				current = node;
			} else {
				current = current.characters[s.charAt(i) - 'a'];
			}
		}
		current.elements ++;
	}
	
	public int delete(String s) {
		Node current = root;
		for (int i = 0; i < s.length(); i++) {
			if (current.characters[s.charAt(i) - 'a'] == null) {
				throw new RuntimeException("Palavra não encontrada");
			} else {
				current = current.characters[s.charAt(i) - 'a'];
			}
		}
		if(current.elements ==0) {
			throw new RuntimeException("Palavra não encontrada");
		}else {
			current.elements--;
			return current.elements;
		}
	}

	public static void main(String[] args) {
       Trie trie  = new Trie();
       
		/*
		 * trie.insert("banana"); trie.insert("bota"); trie.insert("banca");
		 * trie.insert("jose");
		 * 
		 * System.out.println(trie.query("banana"));
		 * System.out.println(trie.query("bota"));
		 * System.out.println(trie.query("banca"));
		 * System.out.println(trie.query("jose"));
		 * 
		 * trie.insert("banana"); trie.insert("bota"); trie.delete("jose");
		 * 
		 * System.out.println(trie.query("banana"));
		 * System.out.println(trie.query("bota"));
		 * System.out.println(trie.query("banca"));
		 * System.out.println(trie.query("jose"));
		 * 
		 */
       
         String teste = "banana";
         
			/*
			 * for( int i = teste.length()-1; i > 0; i--) {
			 * trie.insert(teste.substring(i,teste.length())); }
			 */
         
			
			for (int i = 0; i <= teste.length(); i++) {
				String v= teste.substring(0, i);
				System.out.println(v);
				trie.insert(v);
			}
			 
         trie.insert("bana");
         System.out.println(trie.query("bana"));
         
         
	}
}
