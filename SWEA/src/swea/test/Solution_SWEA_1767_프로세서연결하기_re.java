package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1767_프로세서연결하기_re {
	
	static int T, N, arr[][], total, ans, maxCnt;
	static ArrayList<Node> list;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			arr = new int[N][N];
			ans = Integer.MAX_VALUE;
			maxCnt = Integer.MIN_VALUE;
			total = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					
					if(i!=0&&j!=0&&i!=N-1&&j!=N-1) {
						if(arr[i][j]==1) {
							list.add(new Node(i,j));
							total++;
						}
					}
				}
			}
			
			
			dfs(0,0);
			
			System.out.println("#"+t+" "+ans);
		}
		
	}
	

	
	private static void dfs(int idx, int cnt) {
		if(idx==total) {
			//전선 길이 체크
			
			int length = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]==2) {
						length++;
					}
				}
			}
			
			if(maxCnt<cnt) {
				maxCnt = cnt;
				ans = length;
			}else if( maxCnt==cnt ){
				ans = Math.min(ans, length);
			}
			
			return;
		}
		
		
		Node n = list.get(idx);
		int x = n.x;
		int y = n.y;
		
		for (int d = 0; d < 4; d++) {
			int nx = x;
			int ny = y;
			
			//전선 놓을 수 있는지 확인
			boolean flag = true;
			while(true) {
				nx+=dx[d];
				ny+=dy[d];
				if(nx>=0&&ny>=0&&ny<N&&nx<N) {
					if(arr[nx][ny]!=0) flag = false;
				}else {
					break;
				}
			}
			
			//전선놓기
			if(flag) {
				nx = x;
				ny = y;
				while(true) {
					nx+=dx[d];
					ny+=dy[d];
					if(nx>=0&&ny>=0&&ny<N&&nx<N) {
						arr[nx][ny]=2;
					}else {
						break;
					}
					
				}
				
				dfs(idx+1, cnt+1);
				
				//전선되돌리기
				nx = x;
				ny = y;
				while(true) {
					nx+=dx[d];
					ny+=dy[d];
					if(nx>=0&&ny>=0&&ny<N&&nx<N) {
						arr[nx][ny]=0;
					}else {
						break;
					}
				}

			}
			
			
		}
		
		//전선 안놓기
		dfs(idx+1, cnt);
		
		
		
	}



	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
