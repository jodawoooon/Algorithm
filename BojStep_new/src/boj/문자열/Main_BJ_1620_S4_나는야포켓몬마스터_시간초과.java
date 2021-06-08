package boj.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
String 배열 시간초과

Hash Map (대량 데이터 탐색에 효과적)
각각 key가 String, Integer인 2개의 맵을 만들었다
dictByNum => Integer로 포켓몬 검색
dictByStr => String으로 포켓몬 검색

*/
import java.util.StringTokenizer;


public class Main_BJ_1620_S4_나는야포켓몬마스터_시간초과 {
	static int N, M;
	static String[] dict;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dict = new String[N+1];
		
		//포켓몬 도감
		for (int i = 1; i <= N; i++) {
			dict[i] = br.readLine();
		}
		
		//문제
		for (int i = 0; i < M; i++) {
			//숫자 또는 문자열이 들어온다
			boolean isNum = true;
			
			String input = br.readLine();
			if(input.charAt(0)<'0'||input.charAt(0)>'9') {
				//포켓몬의 이름은 모두 영어 -> 첫글자가 숫자가 아니라면 문자열이라는 뜻
				isNum = false;
			}
			
			
			if(isNum) {
				System.out.println(dict[Integer.parseInt(input)]);
			}else {
				
				for (int j = 1; j <= N; j++) {	
					if(dict[j].equals(input)) {
						System.out.println(j);
						break;
					}
				}
			}
			
		}
		
		
	}
}
