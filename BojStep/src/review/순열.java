package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 순열 {
	
	static int COUNT, N, L;
	static boolean found;
	static String str;
	static char[] src;
	static char[] tgt;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			str = br.readLine();
			if(str==null) break;
			
			//초기화
			sb.setLength(0);
			COUNT = 0;
			found = false;
			
			StringTokenizer st = new StringTokenizer(str);
			src = st.nextToken().toCharArray();
			N = Integer.parseInt(st.nextToken());
			L = src.length;
			tgt = new char[L];
			isSelected = new boolean[L];
			perm(0);
			if(!found) System.out.println(str+" = No Permutation");
			
		}
		
	}
	
	private static void perm (int idx) {
		//기저조건. COUNT가 N이면 멈춘다
		
		if(idx==L){  //수열완성
			COUNT++;
			if(N==COUNT) {
				found = true;
				sb.append(str+" = ").append(tgt);
				System.out.println(sb);
			}
			return;
		}
		
		for (int i = 0; i < L; i++) {
			if(isSelected[i]) continue;
			
			//선택안됐으면
			tgt[idx] = src[i];
			isSelected[i] = true;
			perm(idx+1);
			isSelected[i] = false;
		}
		
		
	}
}
