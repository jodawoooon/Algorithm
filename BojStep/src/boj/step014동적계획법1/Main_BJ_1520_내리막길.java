package boj.step014동적계획법1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_1520_내리막길 {
	/*
	구르는 돼지가 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽
	아래 지점까지 항상 내리막길로만 이동하는 경로의 개수를 구하는 프로그램
	*/
	static int map[][], M,N;
	static long ans;
	static int dx[] = {-1,1,0,0}; //4방탐색을 하기위한 방향배열
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
			Scanner sc = new Scanner(System.in);
			ans = 0; //경로의 개수
			M = sc.nextInt(); //맵 세로길이
			N = sc.nextInt(); //맵 가로길이
			
			map = new int[M][N]; //산의 지형을 저장할 map 배열
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();//산의 지형 셋팅
				}
			} 
			
			bfs(); //bfs로 경로탐색
			
			System.out.println(ans); //결과출력
		
	}
	
	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0,0,map[0][0])); 
		//초기위치 : 제일 왼쪽 위 지점에서 출발
		
		while(!queue.isEmpty()) {
			Node n = queue.poll(); //queue에서 돼지의 위치와 현재 높이를 꺼낸다
			
			int x = n.x; //돼지의 x좌표
			int y = n.y; //돼지의 y좌표
			int h = n.h; //돼지의 현재 높이
			
			if(x==M-1&&y==N-1) { //목적지에 도착했으면 : 제일 오른쪽 아래 지점
				ans++; //카운트 증가
			}
			
			for (int d = 0; d < 4; d++) { //사방탐색
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(!isIn(nx,ny)) continue; //맵 범위 안에 있어야함
				
				if(h>map[nx][ny]) { //다음 정점(nx,ny)가 내리막길이면
					queue.add(new Node(nx,ny,map[nx][ny])); //이동한다
				}
			}
			
		}
	}
	
	private static boolean isIn(int nx, int ny) {
		//맵의 범위 안에 있는지 체크하는 메소드
		if(nx<0||ny<0||nx>=M||ny>=N) return false;
		return true;
	}

	static class Node{ //돼지의 정보를 저장할 class
		int x,y,h; //(x,y)좌표와 돼지의 현재 높이

		public Node(int x, int y, int h) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;
		}
		
	}
}
