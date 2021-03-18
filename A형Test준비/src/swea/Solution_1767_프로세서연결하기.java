package swea;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_1767_프로세서연결하기 {
	static int N,T,totalCnt, min,max, map[][];
	static ArrayList<int[]> list; //고려해야하는 코어만 담고 있는 리스트
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("1767input.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max=0;
			min=Integer.MAX_VALUE;
			totalCnt = 0;
			

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]= sc.nextInt();
					if(i==0||i==N-1||j==0||j==N-1) {
						continue;
					}
					if(map[i][j]==1) {
						list.add(new int[] {i,j});
						totalCnt++;
					}
				}
			}
			
			
			//1. 가장자리 코어는 배제 시킨다.
			//2. 나머지 코어에 대해서 1,2,3,4,5씩 하나씩 선택해보고 경우를 따진다.
			//3. 부분집합의 논리로 풀어야한다
			//	코어 선택     - 전선연결(상,하,좌,우 쭉 가보기)
			//  코어 선택 X -
			go(0,0);
			System.out.println("#"+t+" "+min);
		}
		
	}
	
	private static void go(int index, int cCnt) { //코어 인덱스, 코어 개수
		//기저조건
		if(index==totalCnt) {
			int res = getLength();//놓아진 전선의 길이 구하기
			
			if(max<cCnt) {//전선길이의합
				max = cCnt;
				min = res;
			}else if(max==cCnt) { //여러방법일경우
				if(res<min) min=res;
			}
				//max>cCnt
				

			return;
		}
		
		
		//코어 선택해서 전선 놓아보기
		int[] cur = list.get(index);
		
		int r = cur[0];
		int c = cur[1];
		
		for (int d = 0; d < 4; d++) {
			if(isAvailable(r,c,d)) { //상하좌우로 경계까지 이동할 수 있는지 확인
				//전선 놓기
				setStatus(r,c,d,2);
				//다음코어로 넘어가기
				go(index+1,cCnt+1);
				
				//놓았던 전선을 되돌려 놓기
				setStatus(r,c,d,0);
			}
		}
		//코어 선택X, 전선X
		go(index+1,cCnt);
		
	}
	
	private static int getLength() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==2) cnt++;
			}
		}
		return cnt;
	}

	private static void setStatus(int r, int c, int d, int s) {
		int nr = r, nc = c;
		while(true) {
			nr+=dr[d];
			nc+=dc[d]; //계속가본다
			if(nr<0||nr>=N||nc<0||nc>=N) {
				break;
			}
			map[nr][nc]=s;
		}
	}
	
	
	
	private static boolean isAvailable(int r, int c, int d) {
		int nr = r, nc = c;
		while(true) {
			nr+=dr[d];
			nc+=dc[d]; //계속가본다
			if(nr<0||nr>=N||nc<0||nc>=N) {
				break;
			}
			if(map[nr][nc]!=0) { //0:빈칸, 1:코어, 2:전선
				return false;
			}
		}
		return true;
	}
	
}
