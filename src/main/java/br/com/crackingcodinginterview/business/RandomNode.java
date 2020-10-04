/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author evaristosrodrigues
 *
 */

class RandomNode_Node {
	RandomNode_Node left;
	RandomNode_Node right;
	int val;

	public RandomNode_Node(int val) {
		this.val = val;
	}
}

public class RandomNode {
	
	RandomNode_Node root;
	int size;
	
	public RandomNode(int val) {
		this.root = new RandomNode_Node(val);
	}
	
	public void insertNode(int val) {
		insertNode(this.root,val);
		size++;
	}
	
	private RandomNode_Node insertNode(RandomNode_Node node, int val) {
		if(node == null) {
			node = new RandomNode_Node(val);
		}else if( val > node.val) {
			node.right =insertNode(node.right, val);
		}else {
			node.left = insertNode(node.left, val);
		}
		return node;
	}	
    public void removeNode(int val) {
    	this.root = removeNode(this.root, val);
    	size--;
    	//TODO esta removendo mesmo que nao tenha o elemento, precisa validar isso;
    	 
    }
	private RandomNode_Node removeNode(RandomNode_Node node, int val){
		if( node == null) {
			return node;
		}
        if(val > node.val) {
        	 node.right = removeNode(node.right,val);
        }else if( val < node.val) {
        	 node.left = removeNode(node.left, val);
        }else {
        	 if(node.left == null) {
        		 node = node.right;
        	 }else if( node.right == null) {
        		 node = node.left;
        	 }else {
        		 RandomNode_Node temp = findMin(node.right);
        		 node.val = temp.val;
        		 node.right = removeNode(node.right, temp.val);
        	 }
        	 
        }
        return node;
	}
	public RandomNode_Node findNode(int val) {
        return findNode(this.root, val);
	}

	private RandomNode_Node findNode(RandomNode_Node node, int val) {
		if(node == null) {
			return node;
		}
		if(val > node.val) {
			return findNode(node.right, val);
		}else if(val < node.val) {
			return findNode(node.left, val);
		}else {
			return node;
		}
	}
	
	private RandomNode_Node findMin(RandomNode_Node root) {
		while( root.left != null) {
			root = root.left;
		}
		return root;
	}
	public void printNodes() {
		printNodes(this.root);
		System.out.println();
	}

	private void printNodes(RandomNode_Node node) {
		if(node == null) {
			return;
		}
		printNodes(node.left);
		System.out.print(node.val);
		System.out.print("-->");
		printNodes(node.right);
		
	}

	public RandomNode_Node getRandomNode() {
		if (root == null) {
			return null;
		}
		int position = (int) (Math.random() * size);
		Queue<RandomNode_Node> queue = new LinkedList<>();
		queue.add(root);
		RandomNode_Node curr = root;
		while (!queue.isEmpty() && position-- > 0) {
			curr = queue.poll();
			if (curr.left != null) {
				queue.add(curr.left);
			}
			if (curr.right != null) {
				queue.add(curr.right);
			}
		}

		return curr;
	}

	public static void main(String[] args) {
		RandomNode tree = new RandomNode(10);
		tree.insertNode(1);
		tree.insertNode(2);
		tree.insertNode(3);
		tree.insertNode(4);
		tree.insertNode(5);
		tree.insertNode(6);
		tree.insertNode(7);
		tree.insertNode(8);
		tree.insertNode(9);
		
		tree.printNodes();
		
		tree.removeNode(10);
		
		tree.printNodes();
	    System.out.println(tree.findNode(5).val);

	}

}
