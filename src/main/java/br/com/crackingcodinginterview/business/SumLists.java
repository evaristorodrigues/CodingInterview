/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class SumLists {

	/**
	 * @param args
	 */
	
	public Node sumReversed(Node nodeA, Node nodeB) {
		if(nodeB == null) {
			return nodeA;
		}else if( nodeA == null) {
			return nodeB;
		}
		boolean goesOne = false;
		Node head = new Node(0);
		Node curr = head;
		while(nodeA!=null && nodeB !=null) {
			int val = nodeA.data + nodeB.data;
			if(goesOne) {
				goesOne = false;
				val++;
			}
			if(val > 9) {
				val = val - 10;
				goesOne = true;
			}
			curr.next = new Node(val);
			curr = curr.next;
			
			nodeA = nodeA.next;
			nodeB = nodeB.next;
		}		
		while( nodeA != null) {
			int val = nodeA.data;
			if(goesOne) {
              val++;
				goesOne = false;
			}
			if(val > 9) {
				val = val - 10;
				goesOne = true;
			}
			curr.next = new Node(val);
			nodeA = nodeA.next;
		}
		while( nodeB != null) {
			int val = nodeB.data;
			if(goesOne) {
              val++;
			  goesOne = false;
			}
			if(val > 9) {
			  val = val - 10;
			  goesOne = true;
			}
			curr.next = new Node(val);
			nodeB = nodeB.next;
		}
		if(goesOne) {
			curr.next = new Node(1);
		}
		return head.next;
	}
	public Node sumReversedRecursive ( Node nodeA, Node nodeB, Integer rest ) {
		if(nodeA == null && nodeB == null) {
			if(rest >0) {
				return new Node(rest);
			}
			return null;
		}
		Integer res = (nodeA!=null? nodeA.data: 0)  + (nodeB !=null? nodeB.data:0) + rest;
		Node node  = new Node(res%10);
		node.next = sumReversedRecursive(nodeA!=null?nodeA.next:null, nodeB!=null?nodeB.next:null, res> 9?1:0);
		return node;
	}
	
	
	public static void main(String[] args) {
		
		SumLists sumLists = new SumLists();
		Node head = new Node(7);
		Node middle = new Node(1);
		Node last = new Node(6);
		
		head.next = middle;
		middle.next = last;
				
		Node head2 = new Node(7);
		Node middle2 = new Node(1);
		Node last2 = new Node(6);
		
		head2.next = middle2;
		middle2.next = last2;
		
		Node res1 = sumLists.sumReversed(head,head2);
		while( res1 != null) {
			System.out.println(res1.data);
			res1 = res1.next;
		}
		System.out.println();
		Node res2 = sumLists.sumReversedRecursive(head,head2,0);
		while( res2 != null) {
			System.out.println(res2.data);
			res2 = res2.next;
		}	
		
		System.out.println();

		
	    head = new Node(1);
		middle = new Node(2);
		last = new Node(3);
		last2 = new Node(4);
		
		head.next = middle;
		middle.next = last;
		last.next = last2;
				
	    head2 = new Node(5);
		middle2 = new Node(6);
		last2 = new Node(7);
		
		head2.next = middle2;
		middle2.next = last2;
		
		Node res3 = sumLists.sumReversedRecursiveB(head,head2);
		
		while( res3 != null) {
			System.out.println(res3.data);
			res3 = res3.next;
		}	
		
		
		

	}
	private Node sumReversedRecursiveB(Node head, Node head2) {
		if( head == null && head2 == null) {
			return null;
		}
		int l1 = length(head);
		int l2 = length(head2);
		
		if( l1 > l2) {
			head2 = completeWithZero(head2, l1 - l2);
		}
		if( l1 < l2) {
			head = completeWithZero(head, l2 - l1);
		}
		NodeSum sum = new NodeSum();
		sum(head, head2, sum);
		
		if(sum.carry > 0) {
			insertBefore(sum.node, 1);
		}
		
		return sum.node;
	}
	
	private void sum(Node head, Node head2, NodeSum nodeSum) {
		if( head == null && head2 == null) {
			return;
		}
		sum( head.next, head2.next, nodeSum);
		
		int sum = head.data + head2.data+ nodeSum.carry;
		nodeSum.node = insertBefore(nodeSum.node, sum%10);
		nodeSum.carry = sum/10;
		
	}

	class NodeSum {
		Node node;
		int carry;
	}
	private Node completeWithZero(Node head2, int e) {
		for( int i =0; i < e; i++) {
			Node node = insertBefore(head2, 0);
			head2 = node;
		}
		return head2;
	}
	private Node insertBefore(Node head, int i) {
		Node node = new Node(i);
		node.next = head;
		return node;
	}
	private int length(Node head) {
		if( head == null) {
			return 0;
		}
		
		int count = 0;
		while( head!=null) {
			count++;
			head = head.next;
		}
		
		return count;
	}
	


}
