package boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_13458_시험감독 {
	static int N,A,B,C,res;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //N개의 시험장
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] A = new int[N+1];
		for (int n = 1; n <= N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}
		
		
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken()); //총감독관이 한 시험장에서 감시할 수 있는 응시자의 수
		C = Integer.parseInt(st.nextToken()); //부감독관이 한 시험장에서 감시할 수 있는 응시자의 수
	
		//총감독관은 오직 1명만 있어야 하고, 부감독관은 여러 명 있어도 된다.
		
		//각 시험장마다 응시생을 모두 감독하기 위해 필요한 감독관의 최소 수를 출력한다.
		
		res = 0;
		for (int n = 1; n <= N; n++) {
			A[n] -= B;
			res++;
			
			if(A[n]>0) {
				res+=A[n]/C;
				
				A[n]%=C;
				if(A[n]>=1) res++;
				
			}

		}
		
		System.out.println(res);
	}
}
