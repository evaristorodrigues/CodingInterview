/**
 * 
 */
package br.com.codingInterview.business.hackerearth.exercises.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Evaristo
 *
 */
public class EscapeFromGrid {

	/**
	 * 
	 */
	public EscapeFromGrid() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
    static int[][] dist = null;
    static  int X =0;
    static int Y=0;
    
    public static int solveIt(int n, int m, int[][] G) {

     dist = new int[n][m];
     X = n;
     Y = m;
     for(int i =0; i < X; i++){
         for(int j =0; j < Y ; j++){
             if(G[i][j] == 2){
                 return explorer(G,i, j);
             }
         }
     }
    return -1;
    }
    
    public static int  explorer(int G[][],int x, int y){
         Queue<int[][]> queue = new LinkedList<int[][]>();
         int[][] dir = {{1,0}, {-1,0},{0,1},{0,-1}};
         int result=-1;
         queue.offer(new int[][]{{x,y}});
         while(!queue.isEmpty()){
             int[][] pos = queue.poll();
             int px = pos[0][0];
             int py = pos[0][1];
             if(px <0 || px > X-1 || py < 0 || py > Y-1 || G[px][py] ==1) continue;
             if(px ==0 || px == X -1 || py ==0 || py == Y-1){
            	// if(result ==-1) {
            	// result = dist[px][py];
            	// }else {
                 //  result = Math.min(result,dist[px][py]);
            	 //}
            	 return dist[px][py];
             }else{
                 for(int[] d: dir){
                     int newPx = px+d[0];
                     int newPy = py+d[1];
                     queue.offer(new int[][]{{newPx,newPy}});
                     dist[newPx][ newPy] = dist[px][py]+1;
                 }
             }
             G[px][py] = 1;
         }         
        return result;
    }

    public static void main(String[] args) throws Exception {
        int[][] G;
        int n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        G = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp[] = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) G[i][j] = Integer.parseInt(temp[j]);
        }
        out.println(solveIt(n, m, G));
        br.close();
        out.close();
    }

}
