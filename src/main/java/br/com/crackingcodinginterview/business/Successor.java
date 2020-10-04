/**
 * 
 */
package br.com.crackingcodinginterview.business;

/**
 * @author evaristosrodrigues
 *
 */

class TreeNodeParent<T>{
	
	public TreeNodeParent<T> left;
	public TreeNodeParent<T> right;
	public TreeNodeParent<T> parent;
	
	public int value;
	
	public TreeNodeParent(int value) {
		this.value = value;
	}
}

public class Successor {

	/**
	 * @param args
	 */
	public TreeNodeParent<Integer> inOrderSucessor(TreeNodeParent<Integer> node){
		if(node == null) {
			return null;
		}
		if( node.right !=null) {
			return leftMost(node.right);
		}else {
			TreeNodeParent<Integer>  curr = node;
			node = node.parent;
			while( node!= null && node.left != curr) {
				curr = node;
				node = node.parent;
			}			
			return node;
		}		
	}
	
	private TreeNodeParent<Integer> leftMost(TreeNodeParent<Integer> node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static void main(String[] args) {
		
		TreeNodeParent<Integer> node = new TreeNodeParent<Integer>(10);
		TreeNodeParent<Integer> node2 = new TreeNodeParent<Integer>(5);
		TreeNodeParent<Integer> node3 = new TreeNodeParent<Integer>(15);
		
		node.left = node2;
		node.right = node3;
		node2.parent = node;
		node3.parent = node;
		
		TreeNodeParent<Integer> node4 = new TreeNodeParent<Integer>(2);
		TreeNodeParent<Integer> node5 = new TreeNodeParent<Integer>(7);
		
		node2.left = node4;
		node2.right = node5;
		node4.parent = node2;
		node5.parent = node2;
		
		TreeNodeParent<Integer> node6 = new TreeNodeParent<Integer>(12);
		TreeNodeParent<Integer> node7 = new TreeNodeParent<Integer>(17);
        
		node3.left = node6;
		node3.right = node7;
		node6.parent = node3;
		node6.parent = node3;

        Successor s = new Successor();
        
        System.out.println(s.inOrderSucessor(node5).value);		

	}

}
