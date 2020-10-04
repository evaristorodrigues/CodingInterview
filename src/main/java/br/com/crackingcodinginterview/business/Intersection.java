/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class Intersection {

	/**
	 * @param args
	 */
	
	public Node findInserctionError(Node headA, Node headB) {
		if(headA == null && headB == null) {
			return null;
		}else if( headA == null || headB == null) {
			return null;
		}
		Node dummy =headA;
		while(dummy.next!=null) {
			dummy = dummy.next;
		}
		dummy.next = headB;
		
		Node curr = headA;
		Node runner = headA.next;
		
		while( runner != null && runner.next != null) {
			if(curr == runner) {
				return curr;
			}
			curr = curr.next;
			runner = runner.next.next;
		}
		
		return null;
	}
	public Node findInserction(Node headA, Node headB) {
        if( headA == null || headB == null) {
			return null;
		}
		
        int lA = length(headA);
        int lB = length(headB);
        
        if( lA < lB) {
        	while( lA++ < lB) {
        		headB = headB.next;
        	}
        }
        
        if( lB < lA) {
        	while( lB++ < lA) {
        		headA = headA.next;

        	}
        }
		
        while( headA!= null && headB!= null) {
        	if(headA == headB) {
        		return headA;
        	}
        	headA = headA.next;
        	headB = headB.next;
        }
		
		return null;
	}
	
	public int length( Node head) {
		int count=0;
		while( head!=null) {
			head = head.next;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Node a1 = new Node(1);
		Node a2 = new Node(2);
		Node a3 = new Node(3);
		Node a4 = new Node(4);
		Node a5 = new Node(5);
		Node a6 = new Node(6);
		
	    a1.next = a2;
	    a2.next = a3;
	    a3.next = a4;
	    a4.next = a5;
	    a5.next = a6;
	    
	    Node b3 = new Node(3);
	    b3.next = a1;
	    
	    Intersection intersection = new Intersection();
	    Node res = intersection.findInserction(a1, b3);
	    
	    if( res!=null) {
	    	System.out.println(res.data);
	    }else {
	    	System.out.println("Deu ruim");
	    }

	}

}
