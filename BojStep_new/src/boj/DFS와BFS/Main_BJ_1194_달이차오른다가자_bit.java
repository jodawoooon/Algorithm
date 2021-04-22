package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1194_달이차오른다가자_bit {
	/*빈 곳 : 언제나 이동할 수 있다. ('.‘로 표시됨)
	벽 : 절대 이동할 수 없다. (‘#’)
	열쇠 : 언제나 이동할 수 있다. 이 곳에 처음 들어가면 열쇠를 집는다. (a - f)
	문 : 대응하는 열쇠가 있을 때만 이동할 수 있다. (A - F)
	민식이의 현재 위치 : 빈 곳이고, 민식이가 현재 서 있는 곳이다. (숫자 0)
	출구 : 달이 차오르기 때문에, 민식이가 가야하는 곳이다. 이 곳에 오면 미로를 탈출한다. (숫자 1)
	*/
	
	static int N,M,ans;
	static char map[][];
	static boolean[][][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<Node> queue = new LinkedList<Node>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new char[N][M];
	    visited = new boolean[N][M][1<<6];
	    
	    
	    for (int i = 0; i < N; i++) {
	    	String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = str.charAt(j);
				map[i][j] = c;
				if(c=='0') {
					queue.add(new Node(i,j,0,0));
					visited[i][j][0] = true;
				}
			}
		}
	     
	    ans = bfs();
	    
	    System.out.println(ans);
	    
	}
	
	private static int bfs() {
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			if(map[n.x][n.y]=='1') {
				return n.cnt;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				int key = n.key;
	            
	            if( ny < 0 || nx < 0 || nx >= N || ny >= M || map[nx][ny] == '#' ) continue;
	            
	            // key
	            if( 'a' <= map[nx][ny] && map[nx][ny] <= 'f' ) {
	                key |= ( 1 << (map[nx][ny] - 'a'));
	            }
	            
	            // 문
	            if( 'A' <= map[nx][ny] && map[nx][ny] <= 'F' ) {
	                if( ( key & ( 1 << (map[nx][ny] - 'A'))) == 0 ) {
	                    continue;
	                }
	            }
	            
	            // visit
	            if( visited[nx][ny][key] ) continue;
	            
	            // queue 에 담기
	            visited[nx][ny][key] = true;
	            queue.offer(new Node(nx, ny, n.cnt + 1 , key));
				
			}
			
		}
		
		return -1;
		
	}

	static class Node{
		int x,y,cnt;
		int key;
		public Node(int x, int y, int cnt, int key) {

			this.x = x;
			this.y = y;
			
			this.cnt = cnt;
			this.key = key;
		}
		
	}
}
