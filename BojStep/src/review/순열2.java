package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 순열2 {
	static int K, N=6;
	static int[] S;
	static int[] T;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			//초기값 K, S 설정
			String str = br.readLine();
			if(str==null) break;
			StringTokenizer st = new StringTokenizer(str, " ");
			K = Integer.parseInt(st.nextToken());
			S = new int[K];
			T = new int[N];
			isSelected = new boolean[K];
			
			
			for (int i = 0; i < K; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			lotto(0);
			
			//
		}
		
	}
	private static void lotto(int i) {
		if(i==N) {
			System.out.println(Arrays.toString(T));
			return;
		}
		
		for (int j = 0; j < K; j++) {
			if(isSelected[j]) continue;
			
			T[i] = S[j];
			isSelected[j] = true;
			lotto(i+1);
			isSelected[j] = false;
		}
		
	}
}
