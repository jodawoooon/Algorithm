package boj.step010Àç±Í;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2447º°Âï±â {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

	
		
		star(N);
		
	}

	private static void star(int n) {
		if(n<3) return;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i>=(3/n)&&i<=(n-3/n)&&j>=(3/n)&&j<=(n-3/n)) {
					System.out.print(" ");
				}else {
					star(n/3);
					System.out.print("*");
					
				}
			}System.out.println();
		}
		
		
	}
}
