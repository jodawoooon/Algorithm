package swea.im;

import java.util.Scanner;

public class Solution_SWEA_10804_문자열의거울상 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {

			char[] temp = sc.next().toCharArray();
			
			for (int i = 0; i < temp.length; i++) {
				
				if(temp[i]=='b') {
					temp[i] = 'd';
				}else if(temp[i]=='d') {
					temp[i] = 'b';
				}else if(temp[i]=='p') {
					temp[i] = 'q';
				}else if(temp[i]=='q') {
					temp[i]='p';
				}
				
			}
			System.out.print("#"+t+" ");
			
			for (int i = temp.length-1; i >= 0; i--) {
				System.out.print(temp[i]);
			}System.out.println();
		}
	}
	
}
