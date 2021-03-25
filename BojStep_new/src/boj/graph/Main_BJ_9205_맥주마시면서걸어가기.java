package boj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9205_맥주마시면서걸어가기 {
	static int T, N, start[], end[], point[][], adjMatrix[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			point = new int[N+2][2];
			start = new int[2];
			end = new int[2];
			adjMatrix = new int[N+2][N+2];
			
			
			//입력받기
			for (int n = 0; n < N+2; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				point[n][0] = Integer.parseInt(st.nextToken());
				point[n][1] = Integer.parseInt(st.nextToken());
				
				if(n==0) {
					start[0] = point[n][0];
					start[1] = point[n][1];
				}
				
				if(n==1) {
					end[0] = point[n][0];
					end[1] = point[n][1];
				}
			}
			
			

			//두 좌표 사이의 거리는 x 좌표의 차이 + y 좌표의 차이 이다. (맨해튼 거리)
			//플로이드와샬 -> 가중치가 주어지지 않았다.
			
			//가중치를 만들어준다
			//i==j이면 0이고 아니면 MAX값으로 초기화
			
			//초기화
			for(int i=0; i<N+2; ++i) {
				for(int j=0; j<N+2; ++j) {
					if(i==j) adjMatrix[i][j]=0;
					else adjMatrix[i][j]=Integer.MAX_VALUE;
				}
			}

			
			//거리를 계산하여 맥주 20캔으로 갈 수 있는 거리이면
			//인접행렬에 넣고, 안되면 MAX값 그대로 남게됨.
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					if(i!=j) {
						int dis = Math.abs(point[i][0]-point[j][0]) + Math.abs(point[i][1]-point[j][1]);
						if(dis<=1000) {
							adjMatrix[i][j] = dis;
						}
					}

				}
			}
			
//			System.out.println("입력");
//			print();
			
			for(int k=0; k<N+2; ++k) {
				for(int i=0; i<N+2; ++i) {
					if(i==k) continue;
					
					
					for(int j=0; j<N+2; ++j) {
						if(i==j || k==j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						//갈수 없는 거리는 Integer.MAX_VALUE이다.
						if(adjMatrix[i][k]==Integer.MAX_VALUE||adjMatrix[k][j]==Integer.MAX_VALUE) continue;
						
						
						if(adjMatrix[i][j] > adjMatrix[i][k]+adjMatrix[k][j]) {
							adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
						}
					}
//					print();
				}
			
			}
			
			
			// adjMatrix[0][N+1] = 집->페스티벌 값 : MAX_VALUE가 아니면 이동할 수 있다.
			if(adjMatrix[0][N+1]<Integer.MAX_VALUE) System.out.println("happy");
			else System.out.println("sad");
			
			
	}
			
			
			
		}
	
	private static void print() {
		for(int i=0; i<N+2; ++i) {
			for(int j=0; j<N+2; ++j) {
				System.out.print(adjMatrix[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("=====================================");
		
	}
	
	
}
