package boj.자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_9375_패션왕신해빈 {
	
	static int N, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			ans = 1;
			N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				String name = st.nextToken();
				String kind = st.nextToken();
				
				
				map.put(kind, map.getOrDefault(kind, 0)+1);
			}
			
			for(String key : map.keySet()) {
				ans *= map.get(key)+1;
			}
			
			System.out.println(ans-1);
			
		}
		
		
		
		
	}
}
