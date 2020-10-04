/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */
public class CheckSubtree {

	/**
	 * @param args
	 */
	
	public boolean isSubtree(TreeNode<Integer> t1, TreeNode<Integer> t2) {
	    if(t1 == null && t2 == null) {
	    	return true;
	    }else if(t1 == null || t2 == null) {
	    	return false;
	    }
		if(validate(t1, t2)) {
			return true;
		}
		
		return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
	}
	
	private boolean validate(TreeNode<Integer> t1, TreeNode<Integer> t2) {
		if(t1 == null && t2 ==null) {
			return true;
		}else if( t1 == null || t2 == null) {
			return false;
		}else if( t1.value != t2.value) {
			return false;
		}		
		return validate(t1.left, t2.left) && validate(t1.right, t2.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
