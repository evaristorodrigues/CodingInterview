/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author evaristosrodrigues
 *
 */
public class BSTSequences {

	public ArrayList<LinkedList<Integer>> generateSequence(TreeNode<Integer> node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

		if (node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}

		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.value);

		ArrayList<LinkedList<Integer>> leftSeq = generateSequence(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = generateSequence(node.right);

		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveList(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}

	private void weaveList(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {

		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}

		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveList(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);

		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveList(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}

	public static void main(String[] args) {

		TreeNode<Integer> node = new TreeNode<Integer>(10);
		TreeNode<Integer> node2 = new TreeNode<Integer>(5);
		TreeNode<Integer> node3 = new TreeNode<Integer>(20);
		node.left = node2;
		node.right = node3;
		node2.left = new TreeNode<Integer>(2);
		node2.right = new TreeNode<Integer>(4);
		node3.right = new TreeNode<Integer>(30);

		for (List<Integer> list : new BSTSequences().allSequences(node)) {
			System.out.println(Arrays.toString(list.toArray()));
		}

	}
	
	
	//Solução livro 

	ArrayList<LinkedList<Integer>> allSequences(TreeNode<Integer> node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		if (node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.value);
		new LinkedList<Integer>();
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}

	void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results,
			LinkedList<Integer> prefix) {
		
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}

		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}

}
