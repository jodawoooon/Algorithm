package boj.시뮬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_2580_스도쿠 {
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	//각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
	//굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
	static int[][] map;
	static int N=9;
	static int listSize;
	static ArrayList<Node> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[N][N];
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) list.add(new Node(i,j));
			}
		}
		//기본 판 셋팅
		listSize = list.size();
		
		dfs(0,0);
		
		
	}
	
	
	private static void dfs(int idx, int cnt) {
		
		if(cnt==listSize) {
			//모든0을 다 ㅈ ㅔ거했다면
			print();
			//return;
			System.exit(0);
		}
		
		
		int x = list.get(idx).x;
		int y = list.get(idx).y;
		
		for (int i = 1; i <= N; i++) {
			if(Rcheck(x,i)&&Ccheck(y,i)&&Bcheck(x,y,i)) {
				map[x][y] = i;
				dfs(idx+1, cnt+1);
				map[x][y] = 0;
			}
		}
	}


	private static boolean Bcheck(int x, int y, int num) {

		//3*3검사
		for (int i = x/3*3; i < x/3*3+3; i++) {
			for (int j = y/3*3; j < y/3*3+3; j++) {
				if(map[i][j]==num)
					return false;
			}
		}
		
		return true;
	}


	private static boolean Ccheck( int y, int num) {

		for (int i = 0; i < N; i++) {
			if(map[i][y]==num) {
				return false;
			}
		} //가로검사
		
		return true;
	}


	private static boolean Rcheck(int x, int num) {
		for (int i = 0; i < N; i++) {
			if(map[x][i]==num) {
				return false;
			}
		} //세로검사
		
		
		return true;
	}
	
	


	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}
}
