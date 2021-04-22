package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_15683_감시 {
	/*
	1번 CCTV는 한 쪽 방향만 감시할 수 있다. => 상 
	2번과 3번은 두 방향을 감시할 수 있는데
	2번은 감시하는 방향이 서로 반대방향이어야 하고, 
	3번은 직각 방향이어야 한다. 
	4번은 세 방향, 5번은 네 방향을 감시할 수 있다.
	
	CCTV는 감시할 수 있는 방향에 있는 칸 전체를 감시할 수 있다.
	CCTV는 벽을 통과할 수 없다. CCTV가 감시할 수 없는 영역은 사각지대라고 한다.
	
	사각 지대의 최소 크기
	*
	*/
	static class Node{
		int x,y,type,dir[];

		public Node(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
			
			switch(type) {
			case 1:
				this.dir = new int[1];
				dir[0] = 0; break;
			case 2:
				this.dir = new int[2];
				dir[0] = 0;
				dir[1] = 2; break;
			case 3:
				this.dir = new int[2];
				dir[0] = 0;
				dir[1] = 3;
				break;
			case 4:
				this.dir = new int[3];
				dir[0] = 0;
				dir[1] = 2;
				dir[2] = 3;
				break;
			case 5:
				this.dir = new int[4];
				dir[0] = 0;
				dir[1] = 1;
				dir[2] = 2;
				dir[3] = 3;
				break;
			}
			
		}
		
		
	}
	static int N,M,map[][],cctvCnt;
	static int dx[] = {0,1,0,-1}; //동 남 서 북
	static int dy[] = {1,0,-1,0};
	static int ans = Integer.MAX_VALUE;
	static ArrayList<Node> cctvList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    map = new int[N][M];
	    cctvList = new ArrayList<>(); //cctv 정보 담아놓을 리스트
	    for (int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>=1&&map[i][j]<=5) {
					cctvList.add(new Node(i,j,map[i][j]));
					
				}

			}
		}


		cctvCnt = cctvList.size();
	    
	    dfs(0);
	    
	    System.out.println(ans);
	}
	private static void print(int[][] tmp) {
		for (int[] ia : tmp) {
			System.out.println(Arrays.toString(ia));
		}
	}
	
	private static void dfs(int cnt) {
		if(cnt==cctvCnt) {
			int[][] tmp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			
			tmp = setMap(tmp);
			
			
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(tmp[i][j]==0) {
						res++;
					}
				}
			}
			//print(tmp);
			ans = Math.min(res, ans);
			return;
		}
		
			Node cctv = cctvList.get(cnt);
			int size = cctv.dir.length;
			int[] tmpdir = new int[size];
			for (int d = 0; d < size; d++) {
				tmpdir[d] = cctv.dir[d];
			}
			
			if(cctv.type==2) {
				for (int i = 0; i < 2; i++) {
					for (int d = 0; d < size; d++) {
						cctv.dir[d] += i;
						cctv.dir[d]%=4;

					}
					dfs(cnt+1);
					for (int d = 0; d < size; d++) {
						cctv.dir[d] = tmpdir[d];
					}
				}
			}else if(cctv.type!=5) {
				for (int i = 0; i < 4; i++) {
					for (int d = 0; d < size; d++) {
						cctv.dir[d] += i;
						cctv.dir[d]%=4;
						
					}
					dfs(cnt+1);
					for (int d = 0; d < size; d++) {
						cctv.dir[d] = tmpdir[d];
					}
				}
			}else {
				dfs(cnt+1);
			}
			
			
			
		
		
	}


	private static int[][] setMap(int[][] tmp) {
		for (int i = 0; i < cctvCnt; i++) {
			Node cctv = cctvList.get(i);
			
			int x = cctv.x;
			int y = cctv.y;
			int size = cctv.dir.length;
			for (int d = 0; d < size; d++) {
				int dir = cctv.dir[d];
				
				int nx = x;
				int ny = y;
				
				while(true) {
					nx += dx[dir];
					ny += dy[dir];
					
					if(nx<0||ny<0||nx>=N||ny>=M) break;
					
					if(tmp[nx][ny]==0) tmp[nx][ny]=-1;
					else if(tmp[nx][ny]==6) break;
				}
			}
		}
		return tmp;
	}
}
