package boj.a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16236_아기상어_sol {
	/*
	 * 물고기 M마리, 아기상어 1마리
	 * 아기상어의 처음 크기는 2
	 * 아기상어는 1초에 한번씩 상하좌우로 한칸씩 이동
	 * 아기상어는 자기보다 큰 물고기는 지나갈 수 없고 나머지칸은 지난갈 수 있다
	 * 자신의 크기보다 작은 물고기만 먹을수 있다. (크기가 같으면 먹을순없고 지나갈수만잇음)
	 * 
	 * 1. 더이상 먹을수있는 물고기가 없다면 엄마상어에게 도움요청
	 * 2. 먹을수있는 물고기가 1마리라면 먹으러감
	 * 3. 먹을수있는 물고기가 1마리보다 많다면 가장 가까운곳으록 감
	 * 4. 거리가 가까운 물고기가 많다면 가장 위의 물고기. 그중 가장 왼쪽에있는 물고기
	 * 5. 아기 상어는 자기 크기와 같은 수의 물고기를 먹으면 크기가 1증가.
	 * 예 크기가 2면 물고기 2마리 먹어야 1 증가
	 * 
	 * 더이상먹을수있는 물고기 없을때까지 시간
	 * 
	 */
	
	static int[] dx = {0,-1,1,0};
	static int[] dy = {-1,0,0,1};


	static int N, sy, sx, sSize, sEatCnt, ans;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Node> queue;
	
	static class Node{
		int y;
		int x;
		int dis;
		public Node(int y, int x, int dis) {
			super();
			this.y = y;
			this.x = x;
			this.dis = dis;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
				
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n==9) {
					sy=i;
					sx=j;
				}
				
				map[i][j]=n;
			}
		}
		sSize = 2;
		go();
		
		
		System.out.println(ans);
		
		
		
		
	}
	
	
	private static void go() {
		while(true) {
			int cnt = bfs();
			if(cnt==0) break;
			ans+=cnt;
		}
		
		
	}


	private static int bfs() {
		int minY = Integer.MAX_VALUE;
		int minX = Integer.MAX_VALUE;
		int minDis = Integer.MAX_VALUE;
		
		visit = new boolean[N][N];
		visit[sy][sx]=true;
		
		queue = new LinkedList<>();
		queue.offer(new Node(sy,sx,0));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(map[node.y][node.x]<sSize&&map[node.y][node.x]!=0) {
				if(node.dis<minDis) {
					minDis=node.dis;
					minY = node.y;
					minX = node.x;
				}else if(node.dis==minDis) {
					if(node.y<minY) {
						minDis=node.dis;
						minY = node.y;
						minX = node.x;
					}else if(node.y==minY) {
						if(node.x<minX) {
							minDis=node.dis;
							minY = node.y;
							minX = node.x;
						}
					}
				}
			}
			
			if(node.dis+1>=minDis) {
				continue;
			}
			for (int d = 0; d < 4; d++) {
				int ny = node.y +dy[d];
				int nx = node.x +dx[d];
				
				if(ny<0||nx<0||ny>=N||nx>=N||visit[ny][nx]||map[ny][nx]>sSize) continue;
				
				visit[ny][nx]=true;
				queue.offer(new Node(ny,nx,node.dis+1));
			}
		}
		
		
		if(minDis==Integer.MAX_VALUE) return 0;
		else {
			sEatCnt++;
			if(sEatCnt==sSize) {
				sSize++;
				sEatCnt=0;
			}
			
			map[minY][minX]=0;
			map[sy][sx]=0;
			sy=minY;
			sx=minX;
		}
		return minDis;
	}
	
	
}
