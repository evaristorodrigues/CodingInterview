/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class CheckBalanced {

	/**
	 * @param args
	 */
	
	public boolean checkBalanced(TreeNode<Integer> root) {
		if( root == null) {
			return false;
		}				
		return checkHeight(root, 1) !=Integer.MIN_VALUE;
	}
	
	private int checkHeight(TreeNode<Integer> node, int level) {
		if( node == null) {
			return level-1;
		}
		int left = checkHeight(node.left, level + 1);
		if( left == Integer.MIN_VALUE) return left;
		
		int right= checkHeight(node.right, level + 1);
		if(right == Integer.MIN_VALUE) return right;
		
		if(Math.abs(left - right) > 1) {
			return Integer.MIN_VALUE;
		}
       return Math.max(left, right);			
	}

	public static void main(String[] args) {
		TreeNode<Integer> node = new TreeNode<Integer>(1);
		TreeNode<Integer> node2 = new TreeNode<Integer>(2);
		TreeNode<Integer> node3 = new TreeNode<Integer>(3);
		node.left = node2;
		node.right = node3;
		TreeNode<Integer> node4 = new TreeNode<Integer>(4);
		TreeNode<Integer> node5 = new TreeNode<Integer>(5);
		node2.left = node4;
		node2.right = node5;
		TreeNode<Integer> node6 = new TreeNode<Integer>(6);
		TreeNode<Integer> node7 = new TreeNode<Integer>(7);
		node3.left = node6;
		node3.right = node7;
		TreeNode<Integer> node8 = new TreeNode<Integer>(8);
		TreeNode<Integer> node9 = new TreeNode<Integer>(9);
		node4.left = node8;
		node4.right = node9;
		TreeNode<Integer> node10 = new TreeNode<Integer>(9);
        node5.left = node10;
        System.out.println(new CheckBalanced().checkBalanced(node));
	}

}
