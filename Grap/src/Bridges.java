import java.util.*;
//those edges in a graph which when break create two or more component of graph
// we  create two array time of insertion and lowest time of insertion
// o(N+E)
public class Bridges {
	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	int timer = 0;
	private void dfs(int node, int parent, int vis[], int tin[], int low[]) {
		vis[node] = 1;
		tin[node] = low[node] = timer++;
		
		for(Integer i: graph.get(node)) {
			if(i==parent) continue;
			
			if(vis[i] != 0 )
				low[node] = Math.min(low[node],tin[i]); 
			else {
				dfs(i,node,vis,tin,low);
				low[node] = Math.min(low[node],low[i]);
				
				if(low[i]>tin[node]) {
					System.out.println(i+"  "+node);
				}
			}
				
		}
	}
	private void printBridges(int n) {
		int vis[] = new int[n];
		int tin[] = new int[n];
		int low[] = new int[n];
		
		for(int i=0;i<n;i++) {
			if(vis[i] == 0) {
				dfs(i,-1,vis,tin,low);
			}
		}
		
	
	}
	public static void main(String[] args) {
		Bridges ob = new Bridges();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			ob.graph.add(new ArrayList<Integer>());
		}
		int e = sc.nextInt();
		for(int i=0;i<e;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			ob.graph.get(v).add(u);
			ob.graph.get(u).add(v);
		}
		
		ob.printBridges(n);
		
	}
}
