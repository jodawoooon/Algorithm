package review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 로또 {
	static int K, N=6;
	static int[] S;
	static int[] T;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {

		while(true) {
			//초기값 K, S 설정

			String str = br.readLine();
			if(str==null) break;
			StringTokenizer st = new StringTokenizer(str, " ");
			K = Integer.parseInt(st.nextToken());
			S = new int[K];
			T = new int[N];

			for (int i = 0; i < K; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			lotto(0, 0);
			
			//
			bw.write("\n");
			
		}
		bw.close();
		br.close();
		
	}
	private static void lotto(int i, int start) throws IOException {
		if(i==N) {
			for (int j : T) {
				bw.write(j+" ");
			}bw.write("\n");

			return;
		}
		//유도파트
		for (int j = start; j < K; j++) {
			T[i] = S[j];
			lotto(i+1, j+1);
		}
		
	}
}
