package boj.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2920_B2_음계 {
	
	static int input[];
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		input = new int[8];
		for (int i = 0; i < 8; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		

		boolean up = true;
		boolean down = true;
	
		for (int i = 0; i < 7; i++) {
			if(input[i]!=(input[i+1]-1)) {
				up = false;
			}
			
			if(input[i]!=(input[i+1]+1)) {
				down = false;
			}
		}
		
		if(up) System.out.println("ascending");
		else if(down) System.out.println("descending");
		else System.out.println("mixed");
	
	}
}
