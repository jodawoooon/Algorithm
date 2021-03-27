package swea.im;

import java.io.*;
import java.util.*;

public class Solution_SWEA_1966_숫자를정렬하자 {
	
	static int N,ans;
	static int arr[];

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			
			arr= new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			//내려갈수있는 애들 내려감
			//교착 상태 체크
			
			
			System.out.print("#"+t+" ");
			for (int i : arr) {
				System.out.print(i+" ");
			}System.out.println();
		}
	}
}
