/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class FirstCommonAncestor {

	/**
	 * @param args
	 */
	
	public TreeNode<Integer> findAncestor(TreeNode<Integer> node,int p, int q){
		if(node == null) {
			return null;
		}
		if(node.value == p || node.value == p) {
			return node;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
