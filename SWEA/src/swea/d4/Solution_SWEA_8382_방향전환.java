package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_8382_방향전환 {
	
	static class Node {
		int x,y,d,cnt;

		public Node(int x, int y, int d, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
		
	}
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	static int x1,x2,y1,y2,ans;
	static int map[][];
	static Queue<Node> queue;
	static boolean visited[][][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer(br.readLine()," ");
	    int T = Integer.parseInt(st.nextToken());
	    
	    
	    for (int t = 1; t <= T; t++) {
	    	
	    	
	    	st = new StringTokenizer(br.readLine()," ");
	        x1 = Integer.parseInt(st.nextToken())+100;
	        y1 = Integer.parseInt(st.nextToken())+100;
	        x2 = Integer.parseInt(st.nextToken())+100;
	        y2 = Integer.parseInt(st.nextToken())+100;
	            
	        queue = new LinkedList<>();
	        
	        map = new int[201][201];
            visited = new boolean[201][201][2]; // 가로 방향, 세로방향
            ans = 0;
            
            
            for (int d = 0; d < 4; d++) {
				int nx = x1 + dx[d];
				int ny = y1 + dy[d];
				
				if(!isIn(nx,ny)) continue;
				
				if(d==0||d==1) {
					visited[x1][y1][0] = true;
                    queue.add(new Node(nx,ny,0,1)); // 0 : 세로
				}else {
					visited[x1][y1][1] = true;
                    queue.add(new Node(nx,ny,1,1)); // 1 : 가로
				}
			}
            
            ans = bfs();
            
            
            System.out.println("#"+t+" "+ans);
		}
	}
	
	private static int bfs() {
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			int x = n.x;
			int y = n.y;
			int dir = n.d;
			int cnt = n.cnt;
			
			if(x==x2&&y==y2) {
				return cnt;
			}
			
			
			if(dir==0) {
				for (int d = 2; d < 4; d++) { //가로
					int nx = x + dx[d];
					int ny = y + dy[d];
					if(!isIn(nx,ny)||visited[nx][ny][1]) continue;
					
					visited[nx][ny][1]= true;
					queue.add(new Node(nx,ny,1,cnt+1));
				}
			}else if(dir==1) {
				for (int d = 0; d < 2; d++) { //세로
					int nx = x + dx[d];
					int ny = y + dy[d];
					if(!isIn(nx,ny)||visited[nx][ny][0]) continue;
					
					visited[nx][ny][0]= true;
					queue.add(new Node(nx,ny,0,cnt+1));
				}
			}
		}
		return 0;
	}

	private static boolean isIn(int r, int c) {
        if ( r>=0 && r<201 & c >=0 && c<201) return true;
        return false;
    }
	     
	   
}
