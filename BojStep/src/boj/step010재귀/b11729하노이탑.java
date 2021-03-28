package boj.step010재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b11729하노이탑 {
	static int N, K, cnt;
	static StringBuilder sb = new StringBuilder();
	//하노이 탑.
	//원판 개수 N  
	//n-1개의 원판을 현재 ->임시 // n번 원판을 현재 -> 목적, n-1개의 원판 임시 -> 목적 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		hanoi(N, 1, 2, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}
	private static void hanoi(int n, int from, int temp, int to) {
		if(n==0) {
			return;
		}
		
		hanoi(n-1, from, to, temp);
		cnt++;
		sb.append(from+" "+to+"\n");
		
		hanoi(n-1, temp, from, to);
	}
}
