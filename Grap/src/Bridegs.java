import java.util.*;
import java.util.Scanner;

public class Bridegs {
	private static long solve(int n,int m, int[][] team) {
		Arrays.sort(team,new Comparator<int[]>() {
			public int compare(int[] t1, int[] t2) {
				if(t1[0]==t2[0])
					return t2[1]-t1[1];
				return t1[0]-t2[0];
			}
		});
		int dp[] = new int[m];
		int[] last = new int[m];
		Arrays.fill(dp, -1);
		for(int i=0;i<m;i++) {
			boolean flag = false;
			int g = team[i][1]-team[i][0]+1;
			int h = Integer.MAX_VALUE;
			if(team[i][0] == 1) {
				dp[i] = g;
				last[i] = team[i][1];
				continue;
			}
			for(int j=i-1;j>=0;j--) {
				if(team[j][1]-team[j][0]>=-1 && dp[j]!=-1 && last[i]+1<=team[i][0]) {
						int val = dp[j]+g;
						h = Math.min(val,h);
						flag =true;
				}
				else
					break;
			}
			if(flag) {
				last[i] = team[i][1];
				dp[i] = h;
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<m;i++) {
			if(team[i][1] == n && dp[i]!=-1)
				ans = Math.min(ans,dp[i]);
		}
		if(ans==Integer.MAX_VALUE) return -1;
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] team = new int[m][2];
		for(int i=0;i<m;i++) {
			int t1 = sc.nextInt();
			int t2 = sc.nextInt();
			team[i][0] = t1;
			team[i][1] = t2;
		}
		System.out.println("\n"+solve(n,m,team));
	}
}
