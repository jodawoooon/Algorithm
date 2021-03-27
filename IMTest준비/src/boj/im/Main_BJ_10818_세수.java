package boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_10818_¼¼¼ö {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		list.add(A);
		list.add(B);
		list.add(C);
		
		int tmp = Math.max(A, Math.max(B, C));
		list.remove(list.indexOf(tmp));
		
		int ans = Math.max(list.get(0), list.get(1));
		System.out.println(ans);
	}
}
