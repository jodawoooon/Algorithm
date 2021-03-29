package boj.수학;

import java.util.Scanner;

public class Main_BJ_11653_소인수분해 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		
		int num = 2;
		while(N!=1) {
			if(N%num==0) {
				N/=num;
				System.out.println(num);
				num=2;
			}else {
				num++;
			}
		}
		
	}
}
