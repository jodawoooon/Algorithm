package swea.im;

import java.util.Scanner;

public class Solution_SWEA_2805_농작물수확하기 {
	
	static int N, ans, arr[][], sum, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		
		//N*N크기의 농장. N은 항상 홀수
		//수확은 항ㅇ상 농장의 크기에 딱 맞는 정사각형 마름모 형태만 가능
		
		//전체 sum에서 가장자리를 빼는게 빠를수도?
		//아니면 가운데를 짜르고
		//위 아래 분리해서 for문
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			sum=0;
			arr = new int[N][N];
			int half = N/2;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				char[] tmp = sc.next().toCharArray();
				for (int j = 0; j < N; j++) {
					arr[i][j]=tmp[j]-'0';
					if(j>=half-cnt&&j<=half+cnt) {
						sum+=arr[i][j];
					}
				}
				if(i<half) cnt++;
				else cnt--;
			}

			System.out.println("#"+t+" "+sum);
		}
	}
}
