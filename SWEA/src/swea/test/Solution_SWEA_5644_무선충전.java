package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_5644_무선충전 {
	/*
	 * 매초마다 특정 BC의 충전 범위에 안에 들어오면 해당 BC에 접속이 가능하다. 
	 * 따라서 T=5에 사용자 A는 BC 3에, 사용자 B는 BC 2에 접속할 수 있다. 
	 * 이때, 접속한 BC의 성능(P)만큼 배터리를 충전 할 수 있다. 
	 * 만약 한 BC에 두 명의 사용자가 접속한 경우, 접속한 사용자의 수만큼 충전 양을 균등하게 분배한다.
	 * BC의 정보와 사용자의 이동 궤적이 주어졌을 때, 
	 * 모든 사용자가 충전한 양의 합의 최댓값을 구하는 프로그램을 작성하라.
	 * 
	 */
	static class Info{
		int x,y,c,p;

		public Info(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
		
		
	}
	static int M,A,routeA[], routeB[], ans;
	static ArrayList<Info> AP;
	static int[] dx = {0,-1,0,1,0}; //이동하지않음, 상, 우, 하, 좌
	static int[] dy = {0,0,1,0,-1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("5644input.txt"));
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     int T = Integer.parseInt(br.readLine());
	
	     for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //총 이동시간 M
			A = Integer.parseInt(st.nextToken()); //BC의 갯수
			
			routeA = new int[M]; //A의 이동정보
			routeB = new int[M]; //B의 이동정보
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				routeA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				routeB[i] = Integer.parseInt(st.nextToken());
			}
			//사용자의 이동정보 입력받음
			
			
			AP = new ArrayList<>();
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken()); //충전범위
				int p = Integer.parseInt(st.nextToken()); //성능
				AP.add(new Info(x,y,c,p));
			}
			
			
			solve();
			
			
			System.out.println("#"+t+" "+ans);
			
		}
	}
	
	private static void solve() {
		int x1 = 1;
		int y1 = 1;
		int x2 = 10;
		int y2 = 10;
		
		
		for (int i = 0; i < M; i++) {
			ans += cal(x1,y1,x2,y2);
			x1 += dx[routeA[i]];
			y1 += dy[routeA[i]];
			x2 += dx[routeB[i]];
			y2 += dy[routeB[i]];
		}
		
		ans += cal(x1,y1,x2,y2);
		
		
	}

	private static int cal(int x1, int y1, int x2, int y2) {
		//0초 일때 충전가능한 BC 있는지 확인
				int BClist_a[] = new int[A];
				int BClist_b[] = new int[A];
				for (int i = 0; i < A; i++) {
					int x = AP.get(i).x;
					int y = AP.get(i).y;
					int c = AP.get(i).c;
					int p = AP.get(i).p;
					int d = Math.abs(x1-x)+Math.abs(y1-y);
					//이때 d가 C이하이면 BC에 접속할 수 있다
					if(d<=c) {
						BClist_a[i] = p;
					}
				}
				for (int i = 0; i < A; i++) {
					int x = AP.get(i).x;
					int y = AP.get(i).y;
					int c = AP.get(i).c;
					int p = AP.get(i).p;
					int d = Math.abs(x2-x)+Math.abs(y2-y);
					//이때 d가 C이하이면 BC에 접속할 수 있다
					if(d<=c) {
						BClist_b[i]=p;
					}
				}
				
				//모든 사용자가 충전한 양의 합의 최댓값
				int sum = 0;
				for (int i = 0; i < A; i++) {
					for (int j = 0; j < A; j++) {
						int tmp = BClist_a[i]+BClist_b[j];
						
						//만약 한 BC에 두 명의 사용자가 접속한 경우, 접속한 사용자의 수만큼 충전 양을 균등하게 분배한다.
						if(i==j) tmp/=2;
						sum = Math.max(sum, tmp);
					}
				}
		return sum;
	}
}
