package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1149_RGB거리 {
	static class cost{
		int red,green,blue;

		public cost(int red, int green, int blue) {
			super();
			this.red = red;
			this.green = green;
			this.blue = blue;
		}

		public cost() {
			// TODO Auto-generated constructor stub
		}
		
	}
	static int N;
	static cost house[], D[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		house = new cost[N+1];
		D = new cost[N+1];
		
		StringTokenizer st = null;
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());
			
			house[n] = new cost(red,green,blue);
		}
		
		//1번 집의 색은 2번 집의 색과 같지 않아야 한다.
		//N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
		//i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
		
		
		//모든 집을 칠하는 비용의 최솟값을 출력한다.
		
		//색깔마다 칠하는 비용이 다름
		//인접한 집끼리는 색이 겹치면 안된다.
		
		
		D[1] = new cost(house[1].red, house[1].green, house[1].blue);
		
		for (int n = 2; n <= N; n++) {
			//모든 경우의 수
			
			D[n] = new cost();
			D[n].red = house[n].red + Math.min(D[n-1].blue, D[n-1].green);
			D[n].green = house[n].green + Math.min(D[n-1].red, D[n-1].blue);
			D[n].blue = house[n].blue + Math.min(D[n-1].red, D[n-1].green);
			
		}
		
		
		int ans = Math.min(D[N].red, Math.min(D[N].blue,D[N].green));
		System.out.println(ans);
	}
}
