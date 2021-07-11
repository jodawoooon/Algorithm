package boj.우선순위큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_BJ_7662_이중우선순위큐 {
	static TreeMap<Integer, Integer> map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			map = new TreeMap<>(); 
	        
			for (int k = 0; k < K; k++) {

		        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		        
		        String command = st.nextToken();
		        int num = Integer.parseInt(st.nextToken());
					
		        if(command.equals("I")) {
		        	
		        	map.put(num, map.getOrDefault(num, 0)+1); //숫자와 해당 숫자의 개수 저장
											
				}else if(command.equals("D")){
						
					if(map.size()==0) continue;			
					//빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
					
					int tgt = ( num==1 ? map.lastKey() : map.firstKey() );
					
					int cnt = map.put(tgt, map.get(tgt)-1);
					if(cnt==1) map.remove(tgt);
				}
				
			}
			
			if(map.size()==0) {
				System.out.println("EMPTY");
			}else {
				System.out.println(map.lastKey()+" "+map.firstKey());
			}
			
			
		}
		
	}

}
