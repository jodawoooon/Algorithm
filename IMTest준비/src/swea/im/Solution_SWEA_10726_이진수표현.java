package swea.im;

import java.util.Scanner;

public class Solution_SWEA_10726_이진수표현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String ans = "";
			//M의 이진수 표현
			String binary = Integer.toBinaryString(M);
			if(binary.length()<4) {
				System.out.println("#"+t+" OFF");
				continue;
			}
			
			
			else{
				for (int i = binary.length()-1; i >= binary.length()-N; i--) {
					if(binary.charAt(i)=='0') {
						System.out.println("#"+t+" OFF");
						break;
					}
					if(i==binary.length()-N) {
						System.out.println("#"+t+" ON");
					}
				}
			}
		}
	}
}
