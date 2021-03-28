package boj.step011브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1018체스판다시칠하기 {
	static int N,M, ans;
	static char[][] arr;
	static String[] startW = {"WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW"};
	static String[] startB = {"BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB"};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		ans = Integer.MAX_VALUE;
	
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		//다시 칠해야 할 부분을 찾는다..
		
		for (int i = 0; i+7 < N ; i++) {
			for (int j = 0; j+7 < M; j++) {
				ans = Math.min(Math.min(ans, solveW(i, j)), solveB(i, j)); //WBWBWB로 바꾸는 결과와 BWBWBW로 바꾸는 결과 중 더 최소값을 ans에 담는다.
			}
			
		}
		
		System.out.println(ans);

	}
	
	private static int solveB(int a, int b) {
		int res = 0;
		for (int i = a; i < a+8; i++) { //8x8 크기의 체스판을 잘라서 몇개를 수정해야 하는지 찾는다.
			for (int j = b; j < b+8; j++) {
				if(arr[i][j] != startB[i-a].charAt(j-b)) {
					res++;
				}
			}
		}
		return res;
	}

	private static int solveW(int a, int b) {
		int res = 0;
		for (int i = a; i < a+8; i++) { //8x8 크기의 체스판을 잘라서 몇개를 수정해야 하는지 찾는다.
			for (int j = b; j < b+8; j++) {
				if(arr[i][j] != startW[i-a].charAt(j-b)) {
					res++;
				}
			}
		}
		return res;
	}
	

}
