package boj.step007¹®ÀÚ¿­;

import java.util.Scanner;

public class b1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		String s = sc.nextLine();
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++) {
			if(!words[i].isEmpty()) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
