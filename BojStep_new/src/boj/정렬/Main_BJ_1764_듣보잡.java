package boj.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BJ_1764_듣보잡 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> hs = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			hs.add(br.readLine());
		}
		
		ArrayList<String> ans = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String str= br.readLine();
			if(hs.contains(str)) ans.add(str);
		}

		
		Collections.sort(ans);
		System.out.println(ans.size());
		for (String string : ans) {
			System.out.println(string);
		}
		
	}
}
