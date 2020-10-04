/**
 * 
 */
package br.com.codingInterview.business.datastructure.java;

/**
 * @author evaristosrodrigues
 *
 */
public class DijkstrasShortestPath {

	/**
	 * @param args
	 */
	public  int[] shortestPathMatrix(int[][] graph , int v, int size ) {
		int[] d = new int[size];
		boolean[] visited = new boolean[size];
		
		for(int i =0; i < size; i++) {
			d[i] = Integer.MAX_VALUE;
			visited[i]= false;
		}		
		d[v]=0;
		int u;
		while( (u = minDistanceMatrix(d,visited,size)) >=0) {
			 visited[u] = true;			 
			 for(int i =0; i < size; i ++) {
				 if(!visited[i] && graph[u][i]> 0 &&d[u]+graph[u][i] < d[i]) {
					 d[i] = d[u]+graph[u][i];
				 }
			 }
		 }
		return d;
	}
	
	private  int minDistanceMatrix(int[] d, boolean[] visited, int size ) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		
		for( int i =0; i < size; i++) {
			if(!visited[i] &&  min > d[i] ) {
				min = d[i];
				index = i;
			}
		}
		
		return index;
	}

	public static void main(String[] args) {
		adjacenteMatrixGraph();
		adjacenteListGraph();		
	}

	private static void adjacenteListGraph() {
		int graph[][] = new int[][] { 
			{ 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 

           DijkstrasShortestPath d = new DijkstrasShortestPath();
           int[] r = d.shortestPathMatrix(graph,0,9);
           
           for( int i =0; i < r.length; i ++) {
        	   System.out.println(r[i]);
           }		
	}

	private static void adjacenteMatrixGraph() {
		int graph[][] = new int[][] { 
			{ 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 

           DijkstrasShortestPath d = new DijkstrasShortestPath();
           int[] r = d.shortestPathMatrix(graph,0,9);
           
           for( int i =0; i < r.length; i ++) {
        	   System.out.println(r[i]);
           }
	}

}
