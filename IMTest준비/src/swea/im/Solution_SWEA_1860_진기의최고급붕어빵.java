package swea.im;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_1860_진기의최고급붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//0초부터시작, M초면 K개 만듬
		
		int T = sc.nextInt();
		for (int t = 0; t <= T; t++) {
			int N = sc.nextInt(); //N명
			int M = sc.nextInt(); 
			int K = sc.nextInt();
			
			
			int num = M*K;
			int[] arr = new int[N];
			//2 2 2 라면 2명, 2초에 2개만듬
			// 3초 4초에 온다
			for (int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			System.out.println(Arrays.toString(arr));
			boolean flag =true;
			for (int i = 0; i < N; i++) {

				int sum = K*(arr[i]/M); 
				if(sum-(i+1)<0) {
					
					flag = false;
					break;
				}
			}
			
			if(flag) {
				System.out.println("#"+t+" Possible");
			}else {
				System.out.println("#"+t+" Impossible");
			}
		}
	}
}
