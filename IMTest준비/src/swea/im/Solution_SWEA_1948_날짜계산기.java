package swea.im;

import java.io.*;
import java.util.*;

public class Solution_SWEA_1948_날짜계산기 {
	
	static int N, T, ans;

	static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("1234input.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= 10; t++) {
			ans=0;
			int M1 = sc.nextInt();
			int D1 = sc.nextInt();
			
			int M2= sc.nextInt();
			int D2 = sc.nextInt();
			
			if(M1==M2) {
				ans = D2-D1+1;
			}
			else {
				ans += days[M1]-D1;

				M1++;
				while(true) {
					if(M1==M2) {
						break;
					}
					ans += days[M1];
					M1++;
				}
				ans+= D2+1;
			}
			
			System.out.println("#"+t+" "+ans);

		}
	}
}
