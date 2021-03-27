package boj.im;

import java.util.*;


public class Main_BJ_17413_단어뒤집기2_2 {
	static String S;
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		//문자열 s : a~z, 0~9, 공백, <, >
		StringBuilder sb = new StringBuilder();
		
		//시작과 끝은 공백 X, <과 >의 개수는 같으며 <이 먼저 등장
		
		S = sc.nextLine();
		
		boolean flag = false;
		
		for (int i = 0; i < S.length(); i++) {
			if(S.charAt(i)=='<') {
				flag = true;
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print('<');
			}else if(S.charAt(i)=='>') {
				flag = false;
				System.out.print('>');
			}else if(flag){
				System.out.print(S.charAt(i));
			}else {
				if(S.charAt(i)==' ') {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(' ');
				}else {
					stack.push(S.charAt(i));
				}
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		
		
	}

}
