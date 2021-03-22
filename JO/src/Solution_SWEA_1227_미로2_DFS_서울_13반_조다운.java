
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1227_미로2_DFS_서울_13반_조다운 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean[][] visited;
	static int T, arr[][], startX, startY, ans;
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("1227input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine());
			ans = 0;
			arr = new int[100][100];
			visited = new boolean[100][100];
			//1은 벽을 나타내며 0은 길, 2는 출발점, 3은 도착점을 
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = str.charAt(j)-'0';
					if(arr[i][j]==2) { //출발점위치저장
						startX = i;
						startY = j;
					}
				}
			}
			
			//visited[startX][startY]=true;
			dfs(startX, startY);
			
			System.out.println("#"+t+" "+ans);
			
		}
	}
	
	private static void dfs(int x, int y) {
		
		if(arr[x][y]==3) {
			ans = 1;
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx>=0&&ny>=0&&nx<100&&ny<100) {
				if(!visited[nx][ny]&&arr[nx][ny]!=1) {
					
					visited[nx][ny]=true;
					dfs(nx,ny);
					visited[nx][ny]=false;
				}
			}
		}
		
	}

}
