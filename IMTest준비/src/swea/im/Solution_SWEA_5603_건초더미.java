package swea.im;

import java.io.*;
import java.util.*;

public class Solution_SWEA_5603_건초더미 {
	
	static int N,s1,s2,ans;
	static int arr[];

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt(); //건초더미 개수
			
			int sum=0;
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				sum+= arr[i];
			}
			
			int avg = sum/N;
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				
				cnt = cnt + Math.abs(avg-arr[i]);
			}

			//4개를 모두 같게 만들자.. 필요한 최소 움직임의 수
			
			//평균 수를 구해보자
			
			
			System.out.println("#"+t+" "+cnt/2);
		}
	}
}
