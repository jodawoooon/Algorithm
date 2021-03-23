package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_BJ_1463_1로만들기 {
	
	static int D[];
	//정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 
	//연산을 사용하는 횟수의 최솟값을 출력하시오.
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		D = new int[N+1];
		
		D[0] = D[1] = 0;
		
		for (int i = 2; i <= N; i++) { //0~N까지 최솟값을 구해 D에저장
			
			// N/3(if(N%3)==0), N/2(if(N%2)==0), N-1 +1이다.
			int min = Integer.MAX_VALUE;
			if(D[i-1]+1<min) min =  D[i-1]+1;
			if(i%3==0) min = Math.min(min, D[i/3]+1);
			if(i%2==0) min = Math.min(min, D[i/2]+1);
			D[i] = min;
		}
		
		System.out.println(D[N]);
	}

}
