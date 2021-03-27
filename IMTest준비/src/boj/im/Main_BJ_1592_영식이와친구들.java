package boj.im;

import java.util.Scanner;

public class Main_BJ_1592_영식이와친구들 {

	//원형으로 앉음. 1~N. 1번이 공받고 던진다. 계속 던지고 반복
	//한사람이 M번 받으면 끝남
	//공을 M번보다 적게 받은 사람이 공을 던질때, 현재 공을 받은 횟수가 홀수번이면
	//자기의 현재 위치에서 시계방향으로 L번째 있는 사람에게, 짝수번이면 반시계 방향으로...
	
	static int N, M, L, cnt;
	static int[] arr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		arr = new int[N];
		
		int idx = 0;
		while(true) {
			arr[idx]++;
			
			//종료조건
			for (int i : arr) {
				if(i==M) {
					System.out.println(cnt);
					return;
				}
			}
		
			if(arr[idx]%2==1) {//공을받은횟수가 홀수번이면, 시계방향
				//0 2 4 => (1,3,5)홀			
				idx = (idx+N-L)%N;
				
			}else{
				idx = (idx+L)%N;
				//1 3 => (2,4) 짝
			}
			
			cnt++;
			
		}
		

	}
}
