package boj.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1032_B1_명령프롬프트 {
	

	static int N, len;
	static String[] file;
	static int[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		file = new String[N];
		
		for (int i = 0; i < N; i++) {
			file[i] = br.readLine();
		}
		
		len = file[0].length();
		check = new int[len];
		
		for (int i = 0; i < len; i++) {
			char tgt = file[0].charAt(i);
			boolean flag = true;
			for (int j = 0; j < N; j++) {
				if(file[j].charAt(i)!=tgt) {
					flag = false;
					break;
				}
			}
			
			if(flag) sb.append(file[0].charAt(i));
			else sb.append('?');
		}
		
		
		
		
		
		System.out.println(sb);
		
	}
}
