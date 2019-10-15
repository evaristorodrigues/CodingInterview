/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Evaristo
 *
 */
public class SymmetricTree {

	/**
	 * 
	 */
	public SymmetricTree() {

	}

	/**
	 * @param args Given a binary tree, check whether it is a mirror of itself (ie,
	 *             symmetric around its center).
	 * 
	 *             For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
	 * 
	 *             1 / \ 2 2 / \ / \ 3 4 4 3
	 * 
	 * 
	 *             But the following [1,2,2,null,3,null,3] is not:
	 * 
	 *             1 / \ 2 2 \ \ 3 3
	 * 
	 * 
	 *             Note: Bonus points if you could solve it both recursively and
	 *             iteratively.
	 */
	// [9,-42,-42,null,76,76,null,null,13,null,13]
	public static void main(String[] args) {
		SymmetricTree s = new SymmetricTree();
		TreeNode root = new TreeNode(9);
		TreeNode left = new TreeNode(-42);
		TreeNode right = new TreeNode(-42);
		root.left = left;
		root.right = right;
		 TreeNode left1 = new TreeNode(3);
		 TreeNode right1 = new TreeNode(3);
		TreeNode left2 = new TreeNode(4);
		TreeNode right2 = new TreeNode(4);

		 left.left =left1;
		left.right = right2;

		right.left = left2;
		right.right = right1;
	//	TreeNode right4 = new TreeNode(13);
	//	TreeNode right5 = new TreeNode(13);

		//left.right.right = right4;
		//right.left.right = right5;

		//System.out.println(s.isSymmetric(root));
		
	}
    //Sem recursividade
	public boolean isSymmetric2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();

			if (left == null && right == null) continue;
			if (left == null || right == null) return false;
			if (left.val != right.val) return false;

			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);

		}
		return true;

	}
	//Com recursividade
	public boolean isSymmetric(TreeNode root) {
		return helperIsSymmetric(root, root);

	}

	private boolean helperIsSymmetric(TreeNode left, TreeNode right) {

		if (left == null && right == null) return true;
		if (left == null || right == null) return false;
		if (left.val != right.val) return false;
		return helperIsSymmetric(left.left,right.right) && helperIsSymmetric(left.right,right.left)  ;
	}

}
