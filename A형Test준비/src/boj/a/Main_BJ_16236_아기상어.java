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

public class Main_BJ_16236_아기상어 {
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
	static boolean[][] visit;
	static boolean flag;
	static int N, arr[][], M, babySharkSize, sharkX, sharkY, time, visitCnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		babySharkSize = 2;
		
		//time= Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==9) {
					sharkX = i;
					sharkY = j;
				}
			}
		}
		int cnt=0;
		flag = true;
		visitCnt=1;
		while(flag) {
			
			flag = false;
			visit = new boolean[N][N];
			
			
			if(cnt==babySharkSize) {
				babySharkSize+=1;
				//System.out.println("cnt"+cnt);
				//System.out.println("size"+babySharkSize);
				cnt=0;
			}

			bfs(sharkX, sharkY);

			if(flag) {
				cnt++;
				//System.out.println(cnt);
			}
			

		}
		
		System.out.println(visitCnt-1);
		
		
		
		
	}
	
	
	private static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();
		
		ArrayList<Node> list = new ArrayList<>();
		queue.add(new Node(i,j,0));
		visit[i][j] = true;
		int limit = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int x = n.x;
			int y = n.y;
			int time= n.time;
			//System.out.println(x+" "+y);

			if(limit<time) {
				break;
			}
			
			
			//return;
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(nx>=0&&ny>=0&&nx<N&&ny<N) {
					if(!visit[nx][ny]&&arr[nx][ny]<=babySharkSize) {
						if(arr[nx][ny]==0||arr[nx][ny]==babySharkSize){
							visit[nx][ny]=true;
							queue.add(new Node(nx,ny,time+1));
						}else {
							visit[nx][ny]=true;
							list.add(new Node(nx,ny,time+1));
							limit = time;
						}
					}
				}
			}
			
			if(list.size()!=0) {
				flag=true;
				Collections.sort(list, new Comparator<Node>() {

					@Override
					public int compare(Node o1, Node o2) {
						if(o1.time==o2.time) {
							if(o1.x==o2.x) {
								return o1.y-o2.y;
							}else {
								return o1.x-o2.x;
							}
						}else {
							return o1.time-o2.time;
						}
					}
					
				});
				
				arr[sharkX][sharkY]=0;
				sharkX=list.get(0).x;
				sharkY=list.get(0).y;
				visitCnt+=list.get(0).time;
				arr[sharkX][sharkY]=9;
				System.out.println(sharkX+" "+sharkY+" "+visitCnt);
				return;
			}
			
		}
	}
	
	static class Node{
		int x,y,time;

		public Node(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
