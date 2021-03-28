package boj.step005;

import java.util.Scanner;

public class b8958 {

	public static void main(String[] args) {
		// 8958 OX퀴즈
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 케이스 개수
		
		for (int i = 0; i < T; i++) {
			String str = sc.next();
			int sum = 0;
			int cnt = 1;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='O') {
					sum += cnt;
					cnt += 1;
				}else {
					cnt = 1;
				}
			}System.out.println(sum);
		}

	}

}
