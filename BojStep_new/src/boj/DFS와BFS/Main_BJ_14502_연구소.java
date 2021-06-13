package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14502_연구소 {
	
	static int N,M,map[][], max;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            map = new int[N][M];
            
            for (int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
    			for (int j = 0; j < M; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
            
            
            //0인곳 중에 3곳을 골라서 => 벽으로 바꾼다.
            //그리고 바이러스를 확산시킨후 안전지역을 카운트한다
            visited = new boolean[N][M];
            
            max = Integer.MIN_VALUE;
            dfs(0,0,0);
            
            System.out.println("#"+t+" "+max);
		}
        
        
	}
	private static void dfs(int i, int j, int cnt) {
		if(cnt==3) {
			int res = getArea();
			max = Math.max(max, res);
			return;
		}
		
		
		for (int r = i; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c]==0&&!visited[r][c]) {
					visited[r][c] =true;
					map[r][c] = 1;
					dfs(r,c,cnt+1);
					map[r][c] = 0;
					visited[r][c]=false;
				}
			}
		}
	}
	
	private static int getArea() {
		int num = 0;
		boolean[][] visit = new boolean[N][M];
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(newMap[i][j]==2) {
					queue.add(new Node(i,j));
				}
			}
		}
		
		//바이러스 퍼트리기
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			int x = n.x;
			int y = n.y;
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx>=0&&ny>=0&&nx<N&&ny<M) {
					if(newMap[nx][ny]==0) {
						newMap[nx][ny]=2;
						queue.add(new Node(nx,ny));
					}
				}
			}
		}
		
		//안전영역 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(newMap[i][j]==0) {
					num++;
				}
			}
		}
		
		
		return num;
	}
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
