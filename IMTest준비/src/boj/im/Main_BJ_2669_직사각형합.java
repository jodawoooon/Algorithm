package boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2669_직사각형합 {
	
	static int[][] arr;
	static boolean[][] check;
	static int X,Y,cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[4][4];
		for (int n = 0; n < 4; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < 4; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
				if(m%2==0) {
					X = Math.max(arr[n][m], X);
				}else {
					Y = Math.max(arr[n][m], Y);
				}
				
			}
		}
		
		check = new boolean[X][Y];
		
		for (int i = 0; i < 4; i++) {
			
			for (int x = arr[i][0]; x < arr[i][2]; x++) {
				for (int y = arr[i][1] ; y < arr[i][3]; y++) {
					if(!check[x][y]) {
						check[x][y] = true;
						cnt++;
					}
				}
			}
			
		}
		
		System.out.println(cnt);
	}
}
