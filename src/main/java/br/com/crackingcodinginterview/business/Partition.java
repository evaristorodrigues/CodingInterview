/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.Currency;

/**
 * @author evaristosrodrigues
 *
 */
public class Partition {

	/**
	 * @param args
	 */
	
	
	//3 -> 5 -> 8 -> 5 -> 113 -> 2 -> 1
	
	
	//head =3
	//tail=3
	//x = 5
	//node = 3
	//next = 5
	
	public Node partitionWithoutOrder( Node node, int x) {
		
		Node head = node;
		Node tail = node;
		
         while(node !=null) {
        	 Node next = node.next;
        	 if(node.data < x) {
        		 node.next = head;
        		 head = node;
        	 }else {
        		 tail.next = node;
        		 tail = node;
        	 }
        	 node = next;
         }
		 tail.next = null;
		
		return head;
		
	}
	
	public Node partitionWithOrder( Node node, int x) {
		if( node == null) {
			return node;
		}
		Node headLeft = null;
		Node currLeft = null;

		Node headRight = null;
		Node currRight = null;
		
		
         while(node !=null) {
        	 Node next = node.next;
        	 node.next = null;
        	 if(node.data < x) {
                if(currLeft == null) {
                	currLeft = node;
                	headLeft = currLeft;
                }else {
                currLeft.next = node;
                currLeft = node;
        	   }
        	 }else {
                if(currRight == null) {
                	currRight = node;
                	headRight = currRight;
                }else {
                	currRight.next = node;
                	currRight = node;
                }
        	 }
        	 node = next;
         }	
		 headLeft.next = headRight;
		 
		 return headLeft;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
