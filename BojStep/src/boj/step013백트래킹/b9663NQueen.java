package boj.step013백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b9663NQueen {
	static int N;
	static int[][] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		/*
		 * N-Queen 문제는 크기가 N × N인 체스판 위에  퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

			N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
			
			퀸은 상하좌우 대각선으로 거리제한 없이 한 방향으로 이동한다.
			이 동선과 겹치지 않게 또 다른 곳에 퀸을 배치해야한다.
			
			=> 각 행별로 놓을수 있는 위치에 있을 때 재귀호출. 모두 배치되면 cnt로 경우의수 찾기
			
			
			1. 재귀호출 
			2. 퀸 놓을수 있는지 조건문
		 */
		
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
