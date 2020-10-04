/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class DeleteMiddleNode {

	/**
	 * @param args
	 */
	
	public void removeMiddle(Node head) {
		if( head == null || head.next == null) {
			return ;
		}
		Node curr = head;
		Node runner = head.next.next;
		// 1 2 3 4 5 6 7 8
		//curr =3
		//fast = 7
		while( runner != null && runner.next != null) {
			runner = runner.next.next;
			curr = curr.next;
		}
		curr.next = curr.next.next;
		
	}
	public static void main(String[] args) {
		
		DeleteMiddleNode dmn = new DeleteMiddleNode();
		Node head = generate(9);
		dmn.removeMiddle(head);
		
		while( head!= null) {
			System.out.println(head.data);
			head = head.next;
		}
		 System.out.println();

//		 head = generate(10);
//		 while( head!= null) {
//			System.out.println(head.data);
//			head = head.next;
//		 }
		 System.out.println("RemoveNode");
		 head = generate(9);
		 Node curr = head;
		 int count = 4;
		 while( count-- > 0 ) {
			curr = curr.next;
		 } 
		  dmn.removeNode(curr);
		  System.out.println();
			while (head != null) {
				System.out.println(head.data);
				head = head.next;
			}

	}
	
	private void removeNode(Node curr) {
	  if(curr == null || curr.next == null) {
		  return;
	  }		
	  Node next = curr.next;
	  curr.data = next.data;
	  curr.next = next.next;
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
