package swea.im;

import java.util.Scanner;

public class Solution_SWEA_10965_제곱수만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int MAX = (int)Math.sqrt(10000000);
		
		int[] prime = prime(MAX);
		
		for (int t = 1; t <= T; t++) {
			int ans = 1;
			int A = sc.nextInt();
			int num = (int)Math.sqrt(A);
			
			if(num*num!=A) {
				for (int i : prime) {
					int cnt = 0;
					while(A%i==0) {
						A /= i;
						cnt++;
					}
					if(cnt%2!=0) {
						ans*=i;
					}
					if(A==1 || i>A) break;
				}
				
				if(A>1)ans*=A;
			}
			
			
			System.out.println("#"+t+" "+ans);
		}
	}

	private static int[] prime(int max) {
		int cnt = 1;
		
		boolean[] arr = new boolean[max+1];
		arr[0] = arr[1] = false;
		arr[2] = true;
		int size = 1;
		for (int i = 3; i <= max; i++) {
			arr[i] = true;
			size++;
		}
		
		for (int i = 3; i <= Math.sqrt(max); i+=2) {
			if(arr[i]) {
				for (int j = i*2; j <=max; j+=i) {
					arr[j] = false;
					size--;
				}
			}
		}
		
		int[] tmp = new int[size];
		int idx=0;
		for (int i = 0; i <=max; i++) {
			if(arr[i])
				tmp[idx++]=i;
		}
		return tmp;
	}
}
