

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_JO_2078_13일의금요일 {
	
	static int m[]= {31,28,31,30,31,30,31,31,30,31,30,31};
	static int[] cnt;
	static int day;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		cnt = new int[7];
		//각 달의 13번째가 되는 날의 요일의 개수를 계산하여 “월, 화, 수, 목, 금, 토, 일” 순으로 출력한다.
		
		//N년 동안이란, 1900년 1월 1일을 시작으로 1900+N-1년의 12월 31일까지를 뜻한다. 
		//N은 400 보다 작거나 같다.

		day = 13;
		
		for (int y = 1900; y < 1900+N; y++) {
			if((y%400==0)||(y%4==0&&y%100!=0)) {
				m[1] = 29;
			}else m[1] = 28;
			//윤년설정
			
			for (int i = 0; i < 12; i++) {
				cnt[((day-1))%7]++;
				day += m[i];
			}
		}
		
		for (int i = 0; i < 7; i++) {
			System.out.print(cnt[i]+" ");
		}
	}
}
