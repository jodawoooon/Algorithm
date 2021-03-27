package boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_8958_OX퀴즈 {

	//원형으로 앉음. 1~N. 1번이 공받고 던진다. 계속 던지고 반복
	//한사람이 M번 받으면 끝남
	//공을 M번보다 적게 받은 사람이 공을 던질때, 현재 공을 받은 횟수가 홀수번이면
	//자기의 현재 위치에서 시계방향으로 L번째 있는 사람에게, 짝수번이면 반시계 방향으로...

	static int T, ans, sum;
	static char tmp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			sum = 0;
			ans = 0;
			String str = br.readLine();
			
			for (int s = 0; s < str.length(); s++) {
				
				if(str.charAt(s)=='O') {
					ans++;
					sum += ans;
				}else {
					ans = 0;
				}
			}
			System.out.println(sum);
		}
		
		

	}
}
