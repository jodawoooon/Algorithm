package boj.구현;

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

/*
String 배열 시간초과

Hash Map (대량 데이터 탐색에 효과적)
각각 key가 String, Integer인 2개의 맵을 만들었다
dictByNum => Integer로 포켓몬 검색
dictByStr => String으로 포켓몬 검색

*/

public class Main_BJ_1620_S4_나는야포켓몬마스터 {
	static int N, M;

	static HashMap<String, Integer> dictByStr;
	static HashMap<Integer, String> dictByNum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dictByNum = new HashMap<>(); //key가 숫자인 hash map
		dictByStr = new HashMap<>(); //key가 문자열인 hash map
		
		//포켓몬 도감
		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			
			dictByStr.put(input, i);
			dictByNum.put(i, input);
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
				//입력값이 숫자라면 dictByNum map에서 포켓몬 이름을 찾는다.
				System.out.println(dictByNum.get(Integer.parseInt(input)));
			}else {
				//입력값이 문자라면 dictByStr map에서 포켓몬 번호를 찾는다.
				System.out.println(dictByStr.get(input));
			}
			
		}
		
		
	}
}
