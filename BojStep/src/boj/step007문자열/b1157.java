package boj.step007문자열;

import java.util.Scanner;

public class b1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		
		//단, 대문자와 소문자를 구분하지 않는다.
		//최대 개수 알파벳 구하기
		// 아스키 코드 ?
		
		int[] arr = new int[26];//영문자의 개수는 26개임
		
		for (int i = 0; i < S.length(); i++) {
			if(S.charAt(i) >= 65 && S.charAt(i) <=90) {//대문자 65~90
				arr[S.charAt(i)-'A']++;
			}else {//소문자
				arr[S.charAt(i)-'a']++; //소문자 97~122
			}
		}
		
		int max = -1;
		char C = '?';
		
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				C = (char)(i+'A');
			}else if(arr[i] == max) {
				C = '?';
			}
		}
		
		System.out.println(C);

	}

}
