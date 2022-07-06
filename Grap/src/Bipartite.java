import java.util.ArrayList;
import java.util.*;

public class Bipartite {
	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	private boolean isbipartite(int n) {
		int[] color = new int[n];
		color[0] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while(!q.isEmpty()) {
			int temp = q.poll();
			int currcol = -1*color[temp];
			for(int i: graph.get(temp)) {
				if(color[i] == 0) {
					color[i] = currcol;
					q.add(i);
				}
				else if(color[i] == color[temp])
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Bipartite ob = new Bipartite();
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
		
		System.out.println(ob.isbipartite(n));
	}
}
