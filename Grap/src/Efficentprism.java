//Tc O(Nlogn)
//sc = O(N)

import java.util.*;

public class Efficentprism {
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
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node node1, Node node2) {
				return node1.weight-node2.weight;
			}
		});
		pq.add(new Node(0,key[0]));
		
		for(int i=0;i<n-1;i++) {
			int u = pq.poll().getV();
			mst[u] = true;
			for(Node it: graph.get(u)) {
				if(!mst[it.getV()] && it.getW()<key[it.getV()]) {
					parent[it.getV()] = u;
					key[it.getV()] = it.getW();
					pq.add(new Node(it.getV(),it.getW()));
				}
			}
		}
		
		for(int i = 1;i<n;i++) {
        	System.out.println(parent[i] + " - " + i); 
        }
		
	}
	public void prism() {
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
		Efficentprism ob = new Efficentprism();
		ob.prism();
	}
}


/*
  
9 14
0 1 4
0 7 8
1 7 11
1 2 8
7 6 1
7 8 7
2 3 7
2 5 4
2 8 2
8 6 6
6 5 2
3 4 9
3 5 14
5 4 10
 */
