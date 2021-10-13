import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_21608_S1_상어초등학교 {
	static int N, map[][], ans;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] score = {0, 1, 10, 100, 1000};
	static int[][] likeArr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		likeArr = new int[(N*N)+1][4];
		map = new int[N+1][N+1];
		
		for(int n = 0 ; n < N*N ; n++) {
			st = new StringTokenizer(br.readLine());
			int stdNum = Integer.parseInt(st.nextToken());
			for(int i = 0 ;i < 4 ; i++) {
				likeArr[stdNum][i] = Integer.parseInt(st.nextToken());
			}
			

			int stdX = 0;
			int stdY = 0;
			int likeMax = -1;
			int emptyMax = -1;
			
			for(int i = 1 ; i <= N ; i++) {
				for(int j = 1 ; j <= N ; j++) {
					if(map[i][j]==0) {
						int tmpMax = 0;
						int tmpEmpty = 0;
						for(int d = 0 ; d < 4 ; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if(isIn(nx,ny)){
								if(isLiked(nx,ny,stdNum)) tmpMax++;
								if(map[nx][ny]==0) tmpEmpty++;
							}
						}
						
						if(likeMax<tmpMax) {
							likeMax = tmpMax;
							emptyMax = tmpEmpty;
							stdX = i;
							stdY = j;
						}else if(likeMax == tmpMax) {
							if(emptyMax<tmpEmpty) {
								emptyMax = tmpEmpty;
								stdX = i;
								stdY = j;
							}else if(emptyMax == tmpEmpty) {
								if(stdX>i) {
									stdX = i;
									stdY = j;
								}else if(stdX==i) {
									if(stdY>j) {
										stdY = j;
									}
								}
							}
						}
						
						
					}
				}
			}
			map[stdX][stdY] = stdNum;
		}
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				ans += getScore(i,j,map[i][j]);
			}
		}

		System.out.println(ans);

		
	}

	private static void printMap() {
		for (int i = 1; i <= N ; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
	}

	private static int getScore(int i, int j, int stdNum) {
		int cnt = 0;
		for(int d = 0 ; d < 4 ; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if(isIn(nx,ny)){
				if(isLiked(nx,ny,stdNum)) cnt++;
			}
		}
		
		return score[cnt];
		
	}

	private static boolean isLiked(int nx, int ny, int stdNum) {
		for(int std : likeArr[stdNum]) {
			if(std==map[nx][ny]) return true;
		}
		return false;
	}
	private static boolean isIn(int nx, int ny) {
		if(nx<=0||ny<=0||nx>N||ny>N) return false;
		return true;
	}
}
