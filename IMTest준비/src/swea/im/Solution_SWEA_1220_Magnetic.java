package swea.im;

import java.io.*;
import java.util.*;

public class Solution_SWEA_1220_Magnetic {
	
	static int N,ans;
	static int arr[][];

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("1220input.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		for (int t = 1; t <= 10; t++) {
			N=sc.nextInt();
			
			arr = new int[N][N];
			
			//A로 표시된 붉은 자성체 ; S극에 이끌리며 테이블 아래로 떨어진다
			//B로 표시된 푸른 자성체 ; N극에 이끌리며 테이블 아래로 떨어진다
			//나머지는 서로 충돌. 교착상태
			//반대방향이 하나라도있으면 움직이지 않는다
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//1은 N극 - 아래쪽으로 이 동
			//2는 S극 - 위쪽으로 이동

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[j][i]==2) {
						arr[j][i] = 0;

					}else if(arr[j][i]==1){
						break;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = N-1; j >=0; j--) {
					if(arr[j][i]==1) {
						arr[j][i] = 0;

					}else if(arr[j][i]==2){
						break;
					}
				}
			}
			
			ans=0;
			

				for (int j = 0; j < N; j++) {
					int cnt = 0;
						int x = 0;
						int idx = 1;
						int tmp = 0;
						while(true) {
							int nx = x+idx;
							if(nx>=N) break;

							if(nx<N&&arr[nx][j]==1) {
								tmp = 1;
							}else if(nx<N&&arr[nx][j]==2) {
								if(tmp==1) {
									cnt++;
									tmp =2;
								}
							}
							idx++;

							
						}
						ans += cnt;
					
				}

			
			//내려갈수있는 애들 내려감
			//교착 상태 체크
			
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
