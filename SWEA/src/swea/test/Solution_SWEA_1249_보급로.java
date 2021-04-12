package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_1249_보급로 {
	static int ans, N, map[][], memo[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE;

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			memo = new int[N][N]; //
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0'; //맵
					memo[i][j] = Integer.MAX_VALUE;
				}
			}

			memo[0][0] = 0;

			bfs();

			System.out.println("#" + t + " " + ans);
		}

	}

	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 0));


		while (!queue.isEmpty()) {

			Node n = queue.poll();
			int x = n.x;
			int y = n.y;
			int time = n.time;

			if (x == N - 1 && y == N - 1) {
				//우 하단 도착
				// System.out.println(time);
				ans = Math.min(time, ans);
			}


			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					//이동가능하고
					int ntime = time + map[nx][ny];
					
					if(ntime < memo[nx][ny]) {
						// 이길이 더 최소비용이라면
						memo[nx][ny] = ntime;
						queue.add(new Node(nx, ny, time + map[nx][ny]));
					}

				}
			}
		}
		return;
	}

	static class Node {
		int x, y, time;

		public Node(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}


	}
}
