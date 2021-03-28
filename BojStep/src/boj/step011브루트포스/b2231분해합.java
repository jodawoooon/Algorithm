package boj.step011브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2231분해합 {
	static int N, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//N의 분해합 = N과 N을 이루는 각 자리 수의 합
		//245의 분해합 = 245 + 2 + 4 + 5 = 256. 
		//N의 가장 작은생성자 구하기
		
		//256의 생성자는 여러가지가 있다. 
		
		//브루트포스 방식 -> 1부터 N까지 대입
		//찾으면 종료. 못찾으면 0출력
		
		for (int i = 0; i < N; i++) {
			int num = i;
			int sum = 0;
			
			while(num!=0) {
				sum += num%10; //각 자릿수를 더한다
				num  /= 10;
			}
			
			if(sum + i == N) {
				ans = i;
				break;
			}
				
		}
		System.out.println(ans);
		
	}
}
