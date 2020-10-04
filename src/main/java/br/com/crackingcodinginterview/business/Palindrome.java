/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class Palindrome {

	/**
	 * 
	 */
	public Palindrome() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */

	public boolean isPalindrome(Node head) {
		if (head == null) {
			return true;
		}
		int count = 0;
		Node fast = head;
		while (fast != null && fast.next != null) {
			count++;
			fast = fast.next.next;
		}

		Node second = head.next;
		head.next = null;
		Node original = new Node(0);
		Node curr = original;
		while (second != null) {
			curr.next = new Node(head.data);
			curr = curr.next;

			Node temp = second.next;
			second.next = head;
			head = second;
			second = temp;
		}
		original = original.next;
		while (count-- > 0) {
			if (original.data != head.data) {
				return false;
			}
			original = original.next;
			head = head.next;
		}
		return true;
	}
	// 1 2 3 10 3 2 1

	class Result {
		public Node node;
		public boolean result;

		public Result(Node node, boolean result) {
			this.node = node;
			this.result = result;
		}
	}

	boolean isPalindrome3(Node head) {
		int length = lengthOfList(head);

		Result p = isPalindromeRecurse(head, length);
		return p.result;
	}

	Result isPalindromeRecurse(Node head, int length) {
		if (head == null || length <= 0) { // Even number of nodes
			return new Result(head, true);
		} else if (length == 1) { // Odd number of nodes
			return new Result(head.next, true);
		}

		Result res = isPalindromeRecurse(head.next, length - 2);

		if (!res.result || res.node == null) {
			return res;
		}
		/* Check if matches corresponding node on other side. */
		res.result = (head.data == res.node.data);
		/* Return corresponding node. */
		res.node = res.node.next;
		return res;
	}

	int lengthOfList(Node n) {
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;

	}

	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		Node head = new Node(1);
		Node next = new Node(2);
		Node next2 = new Node(3);
		Node middle = new Node(10);
		Node next3 = new Node(3);
		Node next4 = new Node(2);
		Node next5 = new Node(1);

		head.next = next;
		next.next = next2;
		next2.next = middle;
		middle.next = next3;
		next3.next = next4;
		next4.next = next5;

		//System.out.println(p.isPalindrome(head));
		System.out.println();
		System.out.println(p.isPalindrome3(head));
	}

}
