/**
 * 
 */
package br.com.crackingcodinginterview.business.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author evaristosrodrigues
 *
 */

class GraphNode<T>{
			
	private T value;
	private boolean visited;
	private LinkedList<GraphNode<T>> adjacentes;
	
	public GraphNode(T value) {
		this.value = value;
		this.adjacentes = new LinkedList<>();
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public LinkedList<GraphNode<T>> getAdjacentes() {
		return adjacentes;
	}
	public void setAdjacentes(LinkedList<GraphNode<T>> adjacentes) {
		this.adjacentes = adjacentes;
	}
}

public class Graph<T>{
	
	
    private LinkedList<GraphNode<T>> nodes;
    
    public Graph() {
		nodes = new LinkedList<>();
	}

	public LinkedList<GraphNode<T>> getNodes() {
		return nodes;
	}

	public void setNodes(LinkedList<GraphNode<T>> nodes) {
		this.nodes = nodes;
	}  
	
	public  void DFSTraversal() {
		DFSTraversal(this.nodes.get(0));
	}

	private void DFSTraversal(GraphNode<T> node) {
		if( node == null) {
			return;
		}
		System.out.println(node.getValue());
		node.setVisited(true);
		for(GraphNode<T> adjacent : node.getAdjacentes()) {
			if(!adjacent.isVisited()) {
				DFSTraversal(adjacent);
			}
		}
	}
	
	public void BFSTraversal() {
		
		Queue<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
		GraphNode<T> node = this.getNodes().get(0);
		if( node == null) {
			return;
		}		
		node.setVisited(true);
		queue.add(node);
		while(!queue.isEmpty()) {
			GraphNode<T>  curr = queue.poll();
			System.out.println(curr.getValue());
			for(GraphNode<T> adjacent : curr.getAdjacentes()) {
				if(!adjacent.isVisited()) {
					adjacent.setVisited(true);
					queue.add(adjacent);
				}
			}
		}
	}
	
	
    
    public boolean existsPath( GraphNode<T> start, GraphNode<T> end) {
    	
		Queue<GraphNode<T>> queue = new LinkedList<>();
		start.setVisited(true);
		queue.add(start);
		
		while(!queue.isEmpty()) {
			GraphNode<T> node = queue.poll();
			for(GraphNode<T> adjacent: node.getAdjacentes()) {
				if(!adjacent.isVisited()) {
					if(adjacent == end) {
						return true;
					}
					adjacent.setVisited(true);
					queue.add(adjacent);
				}
			}			
		}		
		return false;
    }
    
    public void cleanVisited() {
    	for(GraphNode<T> node: this.nodes) {
    		node.setVisited(false);
    	}
    }
    
    public static void main(String[] args) {
    	
		GraphNode<Integer> node1 = new GraphNode<Integer>(1);
		GraphNode<Integer> node2 = new GraphNode<Integer>(2);
		GraphNode<Integer> node3 = new GraphNode<Integer>(3);
		GraphNode<Integer> node4 = new GraphNode<Integer>(4);
		GraphNode<Integer> node5 = new GraphNode<Integer>(5);

		node1.getAdjacentes().add(node2);
		node1.getAdjacentes().add(node3);
		node2.getAdjacentes().add(node4);
		node5.getAdjacentes().add(node1);
		
		Graph<Integer> graph = new Graph<Integer>();
		graph.getNodes().add(node1);
		graph.getNodes().add(node2);
		graph.getNodes().add(node3);
		graph.getNodes().add(node4);
		graph.getNodes().add(node5);		
		
		System.out.println(graph.existsPath(node5, node2));
		System.out.println();
		System.out.println("DFS");
		graph.DFSTraversal();
		graph.cleanVisited();
		System.out.println("BFS");
		graph.BFSTraversal();
	}

}
