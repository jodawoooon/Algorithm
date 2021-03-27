package boj.im;

import java.util.Scanner;

public class Main_BJ_1085_직사각형에서탈출 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		// x, y, w-x, h-w
		
		int min = Math.min(x, Math.min(y, Math.min(w-x, h-y)));
		System.out.println(min);
	}
}
