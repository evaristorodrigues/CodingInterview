/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
class Node {
	public Node next;
	public int data;
	public Node(int data) {
		this.data = data;
	}
}

public class RemoveDups {

	/**
	 * @param args
	 */
	//1->3->4->1->5->4
    //1->3->4->5->4
	// 1->3->4->5
	public void deleteDuplicates(Node head){
		if(head == null) {
			return;
		}
		
		Node dummy = head;		
		while(dummy.next != null){
			int data = dummy.data;
			Node current = dummy.next;
			Node previous = dummy;
			while(current != null) {
				if(current.data == data) {
					previous.next = current.next;
					current = current.next;
				}else {
					current = current.next;
					previous = previous.next;
				}
			}
			dummy = dummy.next;
		}
	}
	public static void main(String[] args) {
		RemoveDups rd = new RemoveDups();
        Node head = createNode();
        
        Node dummy = head;
        while(dummy !=null) {
        	System.out.println(dummy.data);
        	dummy = dummy.next;
        }
        System.out.println();
        rd.deleteDuplicates(head);
        
        while(head !=null) {
        	System.out.println(head.data);
        	head = head.next;
        }
        System.out.println();
        System.out.println("Second Option");
        
        head = createNode();
        
        dummy = head;
        while(dummy !=null) {
        	System.out.println(dummy.data);
        	dummy = dummy.next;
        }
        System.out.println();
        rd.deleteDuplicates2(head);
        
        while(head !=null) {
        	System.out.println(head.data);
        	head = head.next;
        }       
        
      
	}
	private void deleteDuplicates2(Node head) {
		if(head == null) {
			return;
		}
		Node curr = head;		
		while( curr.next != null) {
			Node runner = curr;			
			while( runner.next !=null) {
				if(curr.data == runner.next.data) {
					runner.next = runner.next.next;
				}else {
					runner = runner.next;
				}
			}
			curr = curr.next;
		}
		
	}
	private static Node createNode() {
		Node head = new Node(1);
        Node next1 = new Node(3);
        head.next = next1;
        Node next2 = new Node(4);
        next1.next = next2;
        Node next3 = new Node(1);
        next2.next = next3;
        Node next4 = new Node(5);
        next3.next = next4;
        Node next5 = new Node(4);
        next4.next = next5;
		return head;
	}

}
