package boj.시뮬;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1194_달이차오른다가자_arr {
	/*빈 곳 : 언제나 이동할 수 있다. ('.‘로 표시됨)
	벽 : 절대 이동할 수 없다. (‘#’)
	열쇠 : 언제나 이동할 수 있다. 이 곳에 처음 들어가면 열쇠를 집는다. (a - f)
	문 : 대응하는 열쇠가 있을 때만 이동할 수 있다. (A - F)
	민식이의 현재 위치 : 빈 곳이고, 민식이가 현재 서 있는 곳이다. (숫자 0)
	출구 : 달이 차오르기 때문에, 민식이가 가야하는 곳이다. 이 곳에 오면 미로를 탈출한다. (숫자 1)
	*/
	
	static int N,M,startX,startY,ans;
	static char map[][];
	static int key[];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new char[N][M];
	    
	    ans = Integer.MAX_VALUE;
	    
	    for (int i = 0; i < N; i++) {
	    	String str = br.readLine();
			for (int j = 0; j < M; j++) {

				map[i][j] = str.charAt(j);
				if(map[i][j]=='0') {
					startX=i;
					startY=j;
				}
			}
		}
	     
	    bfs(startX, startY);
	    if(ans==Integer.MAX_VALUE) System.out.println(-1);
	    else System.out.println(ans);
	    
	}
	
	private static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][][][][][][][] visited = new boolean[N][M][2][2][2][2][2][2];
		key = new int[6];
		queue.add(new Node(i,j,0,key));
		visited[i][j][0][0][0][0][0][0] = true;
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			//System.out.println(map[n.x][n.y]+" "+n.x+" "+n.y+" "+n.cnt);
			if(map[n.x][n.y]=='1') {
				ans = n.cnt;
				return;
				
			}
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				
				
				if(visited[nx][ny][n.keys[0]][n.keys[1]][n.keys[2]][n.keys[3]][n.keys[4]][n.keys[5]]) continue;
				
				if(map[nx][ny]>='a'&&map[nx][ny]<='f') { //열쇠를 찾으면
					
					visited[nx][ny][n.keys[0]][n.keys[1]][n.keys[2]][n.keys[3]][n.keys[4]][n.keys[5]] = true;
					int key[] = new int[6];
					key = n.keys.clone();
					key[map[nx][ny]-'a']=1;
					queue.add(new Node(nx,ny,n.cnt+1,key));
				}
				
				else if(map[nx][ny]>='A'&&map[nx][ny]<='F') {
					//문을 찾으면
					if(n.keys[map[nx][ny]-'a'+32]==1) {
						visited[nx][ny][n.keys[0]][n.keys[1]][n.keys[2]][n.keys[3]][n.keys[4]][n.keys[5]] = true;
						queue.add(new Node(nx,ny,n.cnt+1,n.keys));
					}
				}
				
				else if(map[nx][ny]=='.'||map[nx][ny]=='1'||map[nx][ny]=='0'){
			
					visited[nx][ny][n.keys[0]][n.keys[1]][n.keys[2]][n.keys[3]][n.keys[4]][n.keys[5]] = true;
					queue.add(new Node(nx,ny,n.cnt+1,n.keys));
				}
				
			}
			
		}
		
		
		
	}

	static class Node{
		int x,y,cnt;
		int[] keys;
		public Node(int x, int y, int cnt, int[] key) {
			super();
			this.x = x;
			this.y = y;
			keys = new int[6];
			keys = key.clone();
			this.cnt = cnt;
		
		}
		
	}
}
