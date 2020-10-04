/**
 * 
 */
package br.com.codingInterview.business.datastructure.java;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author evaristosrodrigues
 *
 */
public class Graph_Table {

    int[][] adjacentes = null;
    int count = 0;
    public Graph_Table(int size) {
		this.adjacentes = new int[size][size+1];
	}	
	
	public static void main(String[] args) {
		Graph_Table myGraph = new Graph_Table(7);	
		myGraph.addEdge(3, 1); 
		myGraph.addEdge(3, 4); 
		myGraph.addEdge(4, 2); 
		myGraph.addEdge(4, 5); 
		myGraph.addEdge(1, 2); 
		myGraph.addEdge(1, 0); 
		myGraph.addEdge(0, 2); 
		myGraph.addEdge(6, 5);
		myGraph.showConnections();
		System.out.println("#######################STACK###########################");
		depthFirstSearch(myGraph, 1);
		System.out.println("#######################QUEUE###########################");
		breadthFirstSearch(myGraph, 1);
		System.out.println("##################DELE 6 ################################");
		myGraph.showConnections();
		System.out.println("##################REMOVE EDGE 4 5 ################################");		
		removeEdge(myGraph,4,5);
		myGraph.showConnections();

	}


	private static void breadthFirstSearch(Graph_Table myGraph, int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		LinkedHashSet<Integer> visited =new  LinkedHashSet<Integer>();
		queue.add(i);
		visited.add(i);
		while(!queue.isEmpty()) {
			Integer pos = queue.poll();
			System.out.println(pos);
			for(int j = 0; j < myGraph.adjacentes[pos].length; j++) {
				if(myGraph.adjacentes[pos][j] ==1 && !visited.contains(j)) {
					queue.add(j);
					visited.add(j);
				}
			}
		}		
	}

	private static void depthFirstSearch(Graph_Table myGraph, int i) {
		Stack<Integer> stack = new Stack<Integer>();
		LinkedHashSet<Integer> visited = new LinkedHashSet<Integer>();
		stack.push(i);
		while(!stack.isEmpty()) {
			Integer pos = stack.pop();
			if(!visited.contains(pos)) {
				visited.add(pos);
				System.out.println(pos);
				for( int j=0; j < myGraph.adjacentes[pos].length; j ++) {
					if(myGraph.adjacentes[pos][j]==1) {
						stack.push(j);
					}
				}
			}
		}		
	}

	private static void removeEdge(Graph_Table myGraph, int i, int j) {
		myGraph.adjacentes[i][j]=-1;
		myGraph.adjacentes[j][i+1]=-1;		
	}

	private void showConnections() {
		int x = this.adjacentes.length;
		int y = this.adjacentes[0].length;
		
		for(int i = 0; i < x; i++) {
			for( int j = 1; j < y; j++) {
				if(this.adjacentes[i][j]== 1) {
					System.out.println(i + " "+j);
				}
			}
		}
		
	}

	private void addEdge(int i, int j) {
		this.adjacentes[i][j]=1;
		this.adjacentes[j][i]=1;
		
	}
}
