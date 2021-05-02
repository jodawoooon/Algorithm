package boj.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_2960_에라토스테네스의체 {
	static int N, K, arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//1. 2부터 N까지 모든 정수를 적는다.
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			list.add(i);
		}
		int cnt = 0;
		
		while(list.size()!=0) {
			//2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
			int P = list.get(0);
			
			int mulP = 0;
			while(mulP<=N) {
				mulP += P;
				
				//3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
				
				if(list.contains(mulP)) {
					cnt++;
					//System.out.println(cnt);
					if(cnt==K) {
						System.out.println(mulP);
						return;
					}else {
						list.remove(new Integer(mulP));
					}
					
				}
			}
			
			
		}
		
		
		
	}
}
