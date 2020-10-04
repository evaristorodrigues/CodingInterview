/**
 * 
 */
package br.com.codingInterview.business.datastructure.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author evaristosrodrigues
 *
 */
public class Graph_HashMap {
	
    Map<Integer, List<Integer>> adjacents = new HashMap<>();
    int elements =0;
    
    public void addVertex(Integer v) {
    	adjacents.put(v, new ArrayList<Integer>());
    	elements++;
    }
    public void addEdge(Integer a , Integer b ) {
    	if(adjacents.containsKey(a) && adjacents.containsKey(b)) {
        	adjacents.get(a).add(b);
        	adjacents.get(b).add(a);  		
    	}else {
    		System.out.println("We dont have element");
    	}
    }
    public void showConnections() {
    	adjacents.entrySet().stream().forEach(e -> e.getValue().forEach( v -> System.out.println(e.getKey() + " "+ v)));
    }
	public static void main(String[] args) {
		Graph_HashMap myGraph = new Graph_HashMap();		
		myGraph.addVertex(0);
		myGraph.addVertex(1);
		myGraph.addVertex(2);
		myGraph.addVertex(3);
		myGraph.addVertex(4);
		myGraph.addVertex(5);
		myGraph.addVertex(6);
		myGraph.addEdge(3, 1); 
		myGraph.addEdge(3, 4); 
		myGraph.addEdge(4, 2); 
		myGraph.addEdge(4, 5); 
		myGraph.addEdge(1, 2); 
		myGraph.addEdge(1, 0); 
		myGraph.addEdge(0, 2); 
		myGraph.addEdge(6, 5);
		myGraph.showConnections();
		depthFirstSearch(myGraph, 1);
		System.out.println("##################################################");
		breadthFirstSearch(myGraph, 1);
		System.out.println("##################DELE 6 ################################");
		deleteVertex(myGraph, 6);
		myGraph.showConnections();
		System.out.println("##################REMOVE EDGE 4 5 ################################");		
		removeEdge(myGraph,4,5);
		myGraph.showConnections();
	}
	
	private static void removeEdge(Graph_HashMap g,int i, int j) {
		if(g.adjacents.containsKey(i)) {
			g.adjacents.get(i).remove(j);
		}	
		if(g.adjacents.containsKey(j)) {
			g.adjacents.get(j).remove(i);
		}
	}
	private static void deleteVertex(Graph_HashMap myGraph, int i) {
		myGraph.adjacents.values().stream().forEach(e -> e.remove(i) );
		myGraph.adjacents.remove(i);
	}
	public static void depthFirstSearch(Graph_HashMap g, Integer i) {
		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> visited = new LinkedHashSet<Integer>();
		stack.push(i);
		while(!stack.isEmpty()) {
	      Integer v = stack.pop();
	      if(!visited.contains(v)) {
			visited.add(v);
			System.out.println(v);
			for(Integer e : g.adjacents.get(v)){
				stack.push(e);	
			}
		}
      }
	}
	//1
	//0
	//2
	//4
	//5
	//6
	//3	
	
	public static void breadthFirstSearch(Graph_HashMap g, Integer i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> visited = new LinkedHashSet<Integer>();
		queue.add(i);
		visited.add(i);
		while(!queue.isEmpty()) {
			Integer v = queue.poll();
			System.out.println(v);
			for(Integer e : g.adjacents.get(v)){
				if(!visited.contains(e)){
					queue.add(e);
					visited.add(e);
				}
			}
		}
	}

}



