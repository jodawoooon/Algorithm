package boj.step007¹®ÀÚ¿­;

import java.util.Scanner;

public class b11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		String n = sc.next();
		for (int i = 0; i < N ; i++) {
			sum += n.charAt(i)-'0';
		}
		
		System.out.println(sum);
	}
}
