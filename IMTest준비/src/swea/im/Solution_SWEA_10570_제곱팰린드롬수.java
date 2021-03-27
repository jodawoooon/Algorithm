package swea.im;

import java.util.Scanner;

public class Solution_SWEA_10570_Á¦°öÆÓ¸°µå·Ò¼ö {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t<=T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int cnt = 0;

			for (int i = A; i <= B; i++) {
				double tmp = Math.sqrt(i);
				String str = String.valueOf(i);
				
				boolean flag = true;
				for (int j = 0; j < str.length()/2; j++) {
					char c1 = str.charAt(j);
					char c2 = str.charAt(str.length()-j-1);
					if(c1!=c2) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					if(tmp%1==0) {
						str = String.valueOf((int)tmp);
						boolean flag2 = true;
						for (int j = 0; j < str.length()/2; j++) {
							char c1 = str.charAt(j);
							char c2 = str.charAt(str.length()-j-1);
							if(c1!=c2) {
								flag2 = false;
								break;
							}
							
						}
						if(flag2) {
							cnt++;
						}
					}
				}
				
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
