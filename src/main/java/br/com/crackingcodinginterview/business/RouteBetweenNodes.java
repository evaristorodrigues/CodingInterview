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

class Graph<T>{
	
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
 }
public class RouteBetweenNodes {

	public boolean existRoute(Graph<Integer> graph, GraphNode<Integer> nodeA, GraphNode<Integer> nodeB) {

		Queue<GraphNode<Integer>> queue = new LinkedList<>();
		nodeA.setVisited(true);
		queue.add(nodeA);
		
		while(!queue.isEmpty()) {
			GraphNode<Integer> node = queue.poll();
			for(GraphNode<Integer> adjacent: node.getAdjacentes()) {
				if(!adjacent.isVisited()) {
					if(adjacent == nodeB) {
						return true;
					}
					adjacent.setVisited(true);
					queue.add(adjacent);
				}
			}
			
		}		
		return false;
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
		
		RouteBetweenNodes rbn = new RouteBetweenNodes();
		
		System.out.println(rbn.existRoute(graph, node1, node3));

	}

}
