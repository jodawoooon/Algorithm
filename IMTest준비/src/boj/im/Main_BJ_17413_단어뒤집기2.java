package boj.im;

import java.util.*;

public class Main_BJ_17413_단어뒤집기2 {
	static String S;
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		//문자열 s : a~z, 0~9, 공백, <, >
		StringBuilder sb = new StringBuilder();
		
		//시작과 끝은 공백 X, <과 >의 개수는 같으며 <이 먼저 등장
		
		S = sc.nextLine();
		
		char[] arr = S.toCharArray();
		for (int c = 0; c < arr.length; c++) {
			if(arr[c]==' ') {
				if(!sb.toString().contains("<")) {
				for (int i= sb.length()-1; i >= 0; i--) {
					System.out.print(sb.charAt(i));
				}
				System.out.print(" ");
				sb.setLength(0);
				continue;
				}sb.append(arr[c]);
			}else if(arr[c]=='>') {
				sb.append(arr[c]);
				System.out.print(sb);
				sb.setLength(0);
				continue;
			}else if(arr[c]=='<') {
				if(sb.length()!=0) {
					for (int i= sb.length()-1; i >= 0; i--) {
						System.out.print(sb.charAt(i));
					}
					sb.setLength(0);
					sb.append(arr[c]);
				}else {
					sb.append(arr[c]);
				}
				continue;
			}
			else {
				sb.append(arr[c]);
			}
			
			if(c==arr.length-1) {
				for (int i= sb.length()-1; i >= 0; i--) {
					System.out.print(sb.charAt(i));
			}
		}
		
	}}

}
