/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class ValidateBST {

	/**
	 * @param args
	 */
	
	public boolean isValid(TreeNode<Integer> node) {
		
		return validate(node, null, null);
	}
	private boolean validate(TreeNode<Integer> node, Integer min, Integer max) {
		if( node == null) {
			return true;
		}
		if( min != null && node.value <= min) {
			return false;
		}
		if(max !=null && node.value >= max) {
			return false;
		}		
		return validate( node.left,min,node.value) && validate(node.right,node.value,max);
	}
	public static void main(String[] args) {
		TreeNode<Integer> node = new TreeNode<Integer>(10);
		TreeNode<Integer> node2 = new TreeNode<Integer>(8);
		TreeNode<Integer> node3 = new TreeNode<Integer>(15);
		node.left = node2;
		node.right = node3;
		TreeNode<Integer> node4 = new TreeNode<Integer>(6);
		TreeNode<Integer> node5 = new TreeNode<Integer>(9);
		node2.left = node4;
		node2.right = node5;
		TreeNode<Integer> node6 = new TreeNode<Integer>(14);
		TreeNode<Integer> node7 = new TreeNode<Integer>(16);
		node3.left = node6;
		node3.right = node7;
		TreeNode<Integer> node8 = new TreeNode<Integer>(5);
		TreeNode<Integer> node9 = new TreeNode<Integer>(7);
		node4.left = node8;
		node4.right = node9;
		//TreeNode<Integer> node10 = new TreeNode<Integer>(9);
       // node5.left = node10;
        System.out.println(new ValidateBST().isValid(node));
	}
	    //10
	//8       15
 //7    9   14  16
//6 8  	

}
