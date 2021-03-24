package boj.DFS와BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2636_치즈 {
	static int R,C, arr[][], visited[][], total;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); //세로
		C = Integer.parseInt(st.nextToken()); //가로
		
		arr = new int[R][C];
		
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				//치즈가 없는칸 0, 치즈가 있는칸 1
				if(arr[i][j]==1) total++;
			}
		}

		
		//첫째 줄에는 치즈가 모두 녹아서 없어지는 데 걸리는 시간을 출력하고
		//둘째 줄에는 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수를 출력한다.
		
		//dfs로 바깥쪽 공기를 계속 찾아가면서 바깥공기를 갱신해주어야한다.
		
		//ArrayList<Integer> cntList = new ArrayList<>();
		int preTotal = total;
		int time = 0;
		while(true) {
			
			bfs();
			time++;
			if(total==0) {
				System.out.println(time);
				System.out.println(preTotal);
				break;
			}
			preTotal = total;
		}
		
		
	}
	
	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		visited = new int[R][C];
		
		queue.add(new Node(0,0));
		visited[0][0] = 1;
		
		while(!queue.isEmpty()) {
			
			Node n = queue.poll();
			int r = n.r;
			int c = n.c;
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				
				if(nr>=0&&nc>=0&&nr<R&&nc<C) {
					if(visited[nr][nc]==0) {
						if(arr[nr][nc]==1) {
							arr[nr][nc]=0;
							visited[nr][nc]=1;
							total--;
							
						}else if(arr[nr][nc]==0){
							visited[nr][nc]=1;
							queue.add(new Node(nr,nc));
						}
					}
				}
			}
		}
		
	}

	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}


}
