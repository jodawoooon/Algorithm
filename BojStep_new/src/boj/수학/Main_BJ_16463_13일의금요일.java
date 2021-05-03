package boj.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_16463_13일의금요일 {
	
	static int m[]= {31,28,31,30,31,30,31,31,30,31,30,31};
	static String d[]= {"월","화","수","목","금","토","일"};
	static int day;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//2019년 N년까지 13일의 금요일의 수
		/*
		2019년 1월 1일은 화요일이다. => 2019년 1월 4일은 금요일이다
		
		2월이 29일까지 존재하는 해를 윤년이라고 한다.
		일반적으로 1월부터 12월은 각각 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31일까지 있다. 윤년인 해에는, 2월이 28일까지가 아닌 29일까지 있다.
		400의 배수 연도는 윤년이다.
		400의 배수가 아니면서 100의 배수인 연도는 윤년이 아니다.
		100의 배수가 아니면서 4의 배수인 연도는 윤년이다.
		그 외의 연도는 윤년이 아니다.
		*/
		
		day = 13;
		
		int cnt = 0;
		for (int i = 2019; i <= N; i++) {
			if(i%400==0 || (i%100!=0&&i%4==0)) m[1] = 29;
			else m[1] = 28;
			//윤년설정
			
			for (int j = 0; j < 12; j++) {
				if(d[(day%7)]=="금") cnt++;
				day += m[j];
			}
			
		}
		
		System.out.println(cnt);
	}
}
