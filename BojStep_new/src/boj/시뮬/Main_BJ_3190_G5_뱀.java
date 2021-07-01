package boj.시뮬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_3190_G5_뱀 {
	static int N,K,L, map[][], headX, headY;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			map[R][C] = 1; //사과의 위치
		}
		
		L = Integer.parseInt(br.readLine());
		
		headX = 1;
		headY = 1;
		
		for (int i = 0; i < L; i++) {
			//뱀의 방향 전환
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
//			게임 시작 시간으로부터 X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전시킨다는 뜻이다
			
		}
		
	}
}
