package boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_2810_дех╕╢У {


	static int N, num;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		for (int n = 0; n < N; n++) {
			if(n==0||n==N-1) {
				sb.append('*');
			}
			
			if(str.charAt(n)=='S') {
				sb.append('S');
				sb.append('*');
			}
			if(str.charAt(n)=='L') {
				n++;
				sb.append('L');
				sb.append('L');
				sb.append('*');
			}
			
		}
		
		boolean[] select = new boolean[sb.length()];
		for (int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i)!='*') {
				if(sb.charAt(i-1)=='*'&&!select[i-1]) {
					num++;
					select[i-1]=true;
					continue;
				}
				if(sb.charAt(i+1)=='*'&&!select[i+1]) {
					num++;
					select[i+1]=true;
					continue;
				}
			}
		}

		System.out.println(num);

	}
}
