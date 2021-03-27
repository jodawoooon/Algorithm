package boj.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_9655_µπ∞‘¿” {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int three = N/3;
		int one = N%3;

		
		
		if((three+one)%2==1) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}
	}
}
