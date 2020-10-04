/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author evaristosrodrigues
 *
 */
public class ListOfDepths {

	
	public List<LinkedList<TreeNode<Integer>>> createLinkedListLevelBFS(TreeNode<Integer> root){
		List<LinkedList<TreeNode<Integer>>> lists = new ArrayList<LinkedList<TreeNode<Integer>>>();
		LinkedList<TreeNode<Integer>> depth = new LinkedList<TreeNode<Integer>>();
		if(root!=null) {
			depth.add(root);
		}
		while(depth.size() > 0) {
			lists.add(depth);
			LinkedList<TreeNode<Integer>> curr = depth;
			depth = new LinkedList<TreeNode<Integer>>();
			for(TreeNode<Integer> node : curr) {
				if(node.left!=null) {
					depth.add(node.left);
				}
				if(node.right !=null) {
					depth.add(node.right);
				}
			}
		}
		
	 return lists;	
	}
	public List<LinkedList<TreeNode<Integer>>> createLinkedListLevelDFS(TreeNode<Integer> root){
		List<LinkedList<TreeNode<Integer>>> lists = new ArrayList<LinkedList<TreeNode<Integer>>>();
		createLinkedListLevel(lists, root, 0);		
		return lists;
	}

	public void createLinkedListLevel(List<LinkedList<TreeNode<Integer>>> lists, TreeNode<Integer> node, int level){
        if(node == null) {
        	return;
        }
		LinkedList<TreeNode<Integer>> list = null;
		if( level == lists.size()) {
			list = new LinkedList<TreeNode<Integer>>();
			lists.add(list);
		}else {
			list = lists.get(level);
		}
        list.add(node);        
        createLinkedListLevel(lists, node.left, level+1);
        createLinkedListLevel(lists, node.right, level+1);        
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
