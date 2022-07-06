import java.util.ArrayList;

import java.util.Arrays;
import java.util.*;
class compare implements Comparator<Node> {
	public int compare(Node n1, Node n2) {
		return n1.weight-n2.weight;
	}
}
public class Dijsktra {
	ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	PriorityQueue<Node> p = new PriorityQueue<>(new compare());
	private void shortestpath(int n, int src) {
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		p.add(new Node(src,0));
		
		while(p.size() > 0) {
			Node node = p.poll();
			for(Node i: graph.get(node.v)) {
				if(dist[node.v] + i.weight< dist[i.v]) {
					dist[i.v] = dist[node.v] + i.weight;
					p.add(new Node(i.v,dist[i.v]));
				}
			}
			
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(src+"-"+i+" "+dist[i]+ " ");
		}
		
		
	}
	public static void main(String[] args) {
		Dijsktra ob = new Dijsktra();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			ob.graph.add(new ArrayList<Node>());
		}
		int e = sc.nextInt();
		for(int i=0;i<e;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			ob.graph.get(v).add(new Node(u,w));
			ob.graph.get(u).add(new Node(v,w));
		}
		for(int i=0;i<ob.graph.size();i++) {
			System.out.print(i+"-->");
			for(int j=0;j<ob.graph.get(i).size();j++) {
				System.out.print(" , ("+ob.graph.get(i).get(j).v+"  "+ob.graph.get(i).get(j).weight+") ");
			}
			System.out.println();
		}
		int src = sc.nextInt();
		ob.shortestpath(n,src);
	}
}

class Node{
	int v;
	int weight;
	Node(int v, int weight){
		this.v = v;
		this.weight = weight;
	}
}

/*
 
5
6
0 1 2
0 2 1
1 3 4
1 4 1
2 3 3
3 4 5
0

 
 */
