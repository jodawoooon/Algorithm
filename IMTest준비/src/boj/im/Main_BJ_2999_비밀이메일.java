package boj.im;

import java.util.*;


public class Main_BJ_2999_비밀이메일 {
	//암호 알고리즘
	//R<=C, R*C=N인 R,C를 고른다. 여러개라면 max값
	//그담 R*C 행렬
	//첫번째열부터 C열까지 메세지를 옮긴뒤, 나머지는 두번째 행.. 세번째행..
	//모두 옮겼다면. 첫번째 열의 첫번째 행부터 차례대로 읽으면서 다시 적ㄱ는다...
	
	static int N, R, C;
	static char[][] arr;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		N = str.length();
		//정인이의 암호 이메일이 주어졌을 때, 이를 해독하는 프로그램을 작성하시오.-> 내가 반대로 생각햇네
		//암호화가 아니라 복호화이다.
		
		for (int r = 1; r <= 100; r++) {
			for (int c = 1; c <= 100; c++) {
				if(r<=c&&r*c==N) {
					if(R<r) {
						R=r;
						C=c;
					}
				}
			}
		}
		
		//R*C 행렬 만들기
		arr = new char[R][C];
		int idx = 0;
		//반대로 생각하기
		//먼저 첫번째 열의 첫번째 행부터 R번째 행까지 쓴다
		
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				arr[j][i] = str.charAt(idx++);
			}
		}

		for(char[] c:arr) {
			System.out.println(Arrays.toString(c));
		}

		
		//첫번째 열의 첫번째 행부터 R번째행까지 차례대로 읽기
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(arr[r][c]);
			}
		}
	}
}
