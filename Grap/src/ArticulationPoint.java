import java.util.*;
 
// o(N+E)
//low[i]>=tin[node] && parent != -1
public class ArticulationPoint {
	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	HashSet<Integer> ans = new HashSet<>();
	int timer = 0;
	private void dfs(int node, int parent,int[] vis,int[] tin, int[] low) {
		vis[node] = 1;
		tin[node] = low[node] = timer++;
		int child = 0;
		for(int i: graph.get(node)) {
			if(i==parent) continue;
			
			if(vis[i] == 0) {
				dfs(i,node,vis,tin,low);
				low[node] = Math.min(low[node],low[i]);
				if(low[i]>=tin[node] && parent!= -1) {
					ans.add(node);
				}	
				child++;
			} else {
				low[node] = Math.min(low[node],tin[i]);
			}
		}
		
		if(parent == -1 && child>1) {
			ans.add(node);
		}
	}
	private void printarticulationpoint(int n) {
		int vis[] = new int[n];
		int tin[] = new int[n];
		int low[] = new int[n];
		
		for(int i=0;i<n;i++) {
			if(vis[i] == 0) {
				dfs(i,-1,vis,tin,low);
			}
		}
		
		System.out.println(ans);
	}
	public static void main(String[] args) {
		ArticulationPoint ob = new ArticulationPoint();
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
		
		ob.printarticulationpoint(n);
		
	}
}
