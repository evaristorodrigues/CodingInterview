/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.ArrayList;
import java.util.List;

/**
 * @author evaristosrodrigues
 *
 */
public class PathswithSum {

	/**
	 * @param args
	 */
	
	//Returning the list with all path
	private List<List<Integer>> paths(TreeNode<Integer> node, int target,List<List<Integer>> listas) {
	    if(node == null) {
	    	return null;
	    }
	    
		helperCountPath(node,listas, new ArrayList<Integer>(), target,target);
		
	    paths(node.left,target,listas);
	    paths(node.right,target, listas);	    
	    
	    return listas;
	}

	private void helperCountPath(TreeNode<Integer> node, List<List<Integer>> listas , List<Integer> path,int count, int target) {
	    if(node == null) {
	    	return;
	    }else if(count - node.value == 0) {
	    	path.add(node.value);
			listas.add(path);
			count =target;
			path = new ArrayList<Integer>();
		}else if(count - node.value < 0) {
			count-=target -node.value;
			path = new ArrayList<Integer>();
			path.add(node.value);
		}else{
			count-=node.value;
			path.add(node.value);
		}
	     helperCountPath(node.left,listas,new ArrayList<Integer>(path),count,target);
		 helperCountPath(node.right,listas,new ArrayList<Integer>(path),count,target);	    
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Returning just the count
	private void pathsSum(TreeNode<Integer> node, int target,int[] res) {
	    if(node == null) {
	    	return;
	    }
	    
	    helperCountPathSum(node,res,target, target);
		
		pathsSum(node.left,target,res);
		pathsSum(node.right,target, res);	    
	    
	}

	private void helperCountPathSum(TreeNode<Integer> node, int[] res,int count, int target) {
	    if(node == null) {
	    	return;
	    }else if(count - node.value == 0) {
			count =target;
			res[0]++;
		}else if(count - node.value < 0) {
			count-=target -node.value;
		}else{
			count-=node.value;
		}
	     helperCountPathSum(node.left,res, count,target);
		 helperCountPathSum(node.right,res,count,target);	    
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> node = new TreeNode<Integer>(1);
		TreeNode<Integer> node1 = new TreeNode<Integer>(2);		 
		TreeNode<Integer> node2 = new TreeNode<Integer>(6);
		node.left =node1;
		node.right=node2;
		TreeNode<Integer> node3 = new TreeNode<Integer>(4);
		TreeNode<Integer> node4 = new TreeNode<Integer>(3);
		node1.left = node3;
		node1.right= node4;
		node4.left = new TreeNode<Integer>(1);
		node3.left = new TreeNode<Integer>(1);
		
		//1
    //2	    //3
//4	   //5       
		System.out.println(new PathswithSum().paths(node, 7,new ArrayList<List<Integer>>()));
		int[] res = new int[1];
		new PathswithSum().pathsSum(node, 7, res);
		System.out.println(res[0]);

		

		

	}

}
