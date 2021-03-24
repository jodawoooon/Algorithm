package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1759_암호만들기 {
	/*
	 * 암호는 서로 다른 L개의 알파벳 소문자들로 구성
	 * 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
	 *  암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측
	 *  
	 *  새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다. 
	 *  C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성
	 */
	
	
	static int L, C;

	static boolean arr[], visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new boolean[26];
		visit = new boolean[26];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			char tmp = st.nextToken().charAt(0);
			arr[tmp-'a']=true;
			
		}


		dfs("",0,0,0);
	}
	private static void dfs(String str, int mCnt, int jCnt, int before) {
		if(str.length()==L) {
			if(mCnt>=1&&jCnt>=2) {
				System.out.println(str);
				return;
			}
			
		}
		
		for (int i = 0; i < 26; i++) {
			if(!visit[i]&&arr[i]&&i>=before) {
				
				char tmp = (char) (i+'a');
				if(tmp=='a'||tmp=='e'||tmp=='i'||tmp=='o'||tmp=='u') {
					visit[i]=true;
					dfs(str+tmp, mCnt+1, jCnt, i);
					visit[i]=false;
				}else {
					visit[i]=true;
					dfs(str+tmp, mCnt, jCnt+1, i);
					visit[i]=false;
				}
				
			}

			
		}
	}
}
