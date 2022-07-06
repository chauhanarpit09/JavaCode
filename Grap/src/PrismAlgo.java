
// Space :  O(N)
// time : O(N^2);

import java.util.*;
public class PrismAlgo {
	class Node{
		int v;
		int weight;
		
		Node(int v,int weight){
			this.v = v;
			this.weight = weight;
		}
		
		int getV() {
			return v;
		}
		
		int getW() {
			return weight;
		}
		
	}
	ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	private void mainalgo(int n) {
		int[] key = new int[n];
		int[] parent = new int[n];
		boolean[] mst = new boolean[n];
		Arrays.fill(key,Integer.MAX_VALUE);
		Arrays.fill(parent,-1);
		Arrays.fill(mst,false);
		
		key[0] = 0;
		
		for(int i=0;i<n-1;i++) {
			int min = Integer.MAX_VALUE;
			int u=0;
			for(int v=0;v<n;v++) {
				if(!mst[v] && key[v]<min) {
					min = key[v];
					u = v;
				}
			}
			
			mst[u] = true;
			
			for(Node it: graph.get(u)) {
				if(!mst[it.getV()] && it.getW()<key[it.getV()]) {
					parent[it.getV()] = u;
					key[it.getV()] = it.getW();
				}
			}
		}
	        

		for(int i = 1;i<n;i++) {
        	System.out.println(parent[i] + " - " + i); 
        }
		
		
	}
	public void prims() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			graph.add(new ArrayList<Node>());
		}
		int e = sc.nextInt();
		for(int i=0;i<e;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			graph.get(u).add(new Node(v,w));
			graph.get(v).add(new Node(u,w));
		}
		
		mainalgo(n);
		
	}
	public static void main(String args[]) {
		PrismAlgo ob = new PrismAlgo();
		ob.prims();
	}
}
