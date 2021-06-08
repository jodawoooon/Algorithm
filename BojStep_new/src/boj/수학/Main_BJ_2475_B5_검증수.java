package boj.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2475_B5_검증수 {
	
	static int sum;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		for (int i = 0; i < 5; i++) {
			int input = Integer.parseInt(st.nextToken());
			sum += input*input;
		}
		
		System.out.println(sum%10);
		

	
	}
}
