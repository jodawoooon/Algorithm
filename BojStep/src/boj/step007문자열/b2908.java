package boj.step007¹®ÀÚ¿­;

import java.util.Scanner;

public class b2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		sc.close();
		
		n1 = Integer.parseInt(new StringBuilder().append(n1).reverse().toString());
		n2 = Integer.parseInt(new StringBuilder().append(n2).reverse().toString());
		
		System.out.println(n1>n2?n1:n2);
	}
}
