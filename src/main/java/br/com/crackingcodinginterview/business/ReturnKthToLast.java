/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */


public class ReturnKthToLast {

	/**
	 * @param args
	 */
	
	// 1->2->3->4->5->6->7->8->9->10
	// k = 5
	// fast = 10
	//count =5
	//head = 6
	public Node findKthToLast(Node head, int k) {
		if( head == null) {
			return null;
		}
		int count =1;
		Node fast = head.next;
		while( fast != null && fast.next !=null) {
			fast = fast.next.next;
			count++;
		}
		count*=2;
		if( k > count) {
			return null;
		}
		while( count-- > k) {
		   head = head.next;
		}	
		return head;		
	}
	public static void main(String[] args) {
		
		ReturnKthToLast  rkl = new ReturnKthToLast();
		Node head = generate(10);
		Node curr = head;
        while( curr!= null) {
        	System.out.println(curr.data);
        	curr = curr.next;
        }
        System.out.println();
		System.out.println(rkl.findKthToLast(head, 5).data);
        System.out.println();
		System.out.println(rkl.findKthToLast2(head, 5).data);
        System.out.println();
		System.out.println(rkl.findKthToLastRec(head, 5).data);
        System.out.println();
        
		rkl.findKthToLastRec2(head, 5);		
	}
	private int findKthToLastRec2(Node head, int k) {
		if(head == null) {
			return 0;
		}
		int count = findKthToLastRec2(head.next, k)+1;
		if(count == k) {
			System.out.println(head.data); 
		}
		return count;
	}
	private class Index {
		int idx;
	}
	private Node findKthToLastRec(Node head, int k) {
		if(head == null) {
			return null;
		}
		return findKthToLastRec(head, k, new Index());
	}
	private Node findKthToLastRec(Node head, int k, Index index) {
		if(head == null) {
			return null;
		}
		if(index.idx == k) {
			return head;
		}
		index.idx++;
		return findKthToLastRec(head.next,k,index);
	}
	
	private Node findKthToLast2(Node head, int k) {
		if(head == null) {
			return null;
		}
		Node curr = head;
		Node runner = head;
		while(k-- > 0) {
			runner = runner.next;
		}
		while(runner!= null) {
			curr = curr.next;
			runner = runner.next;
		}
		return curr;
	}
	private static Node generate(int count) {
		Node head = new Node(0);
		Node current = head;
		int i = 1;
		while(count-- > 0) {
			current.next = new Node(i++);
			current = current.next;
		}
		return head.next;
	}
	
}
