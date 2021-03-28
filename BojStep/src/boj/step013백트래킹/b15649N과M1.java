package boj.step013백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b15649N과M1 {
	static int N,M;
	static int[] tgt;
	static boolean[] isSelected;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[N+1];
		tgt = new int[M];
		
		//여기서 중복없이 M개를 고른다
		
		perm(0);
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	private static void perm(int idx) throws IOException {
		if(idx==M) {
			//Arrays.sort(tgt);
			for (int n : tgt) {
				bw.write(String.valueOf(n)+" ");
			}bw.write("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			
			tgt[idx] = i;
			isSelected[i] = true;
			perm(idx+1);
			isSelected[i] = false;
		}
		
	}

}
