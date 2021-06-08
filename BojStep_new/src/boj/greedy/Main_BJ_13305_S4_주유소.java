package boj.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_13305_S4_주유소 {
	
	static int N;
	static long ans, min;
	static long distance[];
	static long cost[];
	//비용 최소화 -> 싼 기름 찾기
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		distance = new long[N-1];
		cost = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			distance[i] = Long.parseLong(st.nextToken()); //도로의 길이
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			cost[i] = Long.parseLong(st.nextToken()); //기름값
		}
		
		min = cost[0];
		for (int i = 0; i < N-1; i++) {
			min = Math.min(cost[i], min);
			ans += (min*distance[i]);
		}
		
		
		System.out.println(ans);
		
	}
}
