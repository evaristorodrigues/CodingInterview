/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class LoopDetection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node a1 = new Node(1);
		Node a2 = new Node(2);
		Node a3 = new Node(3);
		Node a4 = new Node(4);

		
	    a1.next = a2;
	    a2.next = a3;
	    a3.next = a4;
	    a4.next = a2;
	    
	    LoopDetection ld = new LoopDetection();
        Node res = ld.FindBeginning(a1);
	    if( res!=null) {
	    	System.out.println(res.data);
	    }else {
	    	System.out.println("Deu ruim");
	    }
	}
	
	Node FindBeginning(Node head) {
	Node slow = head;
	Node fast = head;

	while (fast != null && fast. next != null) {
		slow = slow.next;
		fast = fast.next.next;
		if (slow == fast) { 
		 break;
	    }
	 }
	
	if (fast == null || fast.next == null) {
	   return null;
	}
	slow = head;
	while (slow != fast) {
	  slow = slow. next;
	  fast = fast.next;
	}
	return fast;
}

}
