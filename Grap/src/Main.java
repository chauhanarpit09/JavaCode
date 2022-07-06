import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed

class Main {
	class Node{
		int v;
		long w;
		Node(int v,long w){
			this.v =v;
			this.w = w;
		}
	}
	private void solve(int n,ArrayList<ArrayList<int[]>> a){
		long[] dist = new long[n+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[1] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
			public int compare(Node a,Node b){
				return (int)(a.w-b.w);
			}
		});
		pq.add(new Node(1,0L));

		while(!pq.isEmpty()){
			Node t = pq.poll();
			for(int[] j:a.get(t.v)){
				long temp = t.v*j[1]+dist[t.v];
				if(temp<dist[j[0]]){
					dist[j[0]] = temp;
					pq.add(new Node(j[0],dist[j[0]] ));
				}
			}
		}

		for(int i=1;i<dist.length;i++){
			if(dist[i]==Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(dist[i]);
		}
	}
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		ArrayList<ArrayList<int[]>> a = new ArrayList<>();
		for(int i=0;i<n+1;i++){
			a.add(new ArrayList<int[]>());
		}

		for(int i=0;i<e;i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			a.get(u).add(new int[]{v,w});
			a.get(v).add(new int[]{u,w});
		}

		Main ob= new Main();
		ob.solve(n,a);

	}
}