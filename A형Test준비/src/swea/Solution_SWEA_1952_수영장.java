package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1952_수영장 {
	static int T, N, K, ans;
	static int price[], arr[];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("1952input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			ans=0;
			price = new int[4];
			arr = new int[12];
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			//
			
			
			
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < 12; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
