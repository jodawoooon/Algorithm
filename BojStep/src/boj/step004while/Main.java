package boj.step004while;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 3032 ³ª¸ÓÁö
		
		
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];
		int cnt = 0;
		for(int k=0;k<10;k++) {
			arr[k] = sc.nextInt()%42;
			
		}
		
		for(int i = 0;i<10;i++) {
			for(int j=i+1;j<10;j++) {
				if(arr[i]==arr[j]) {
					cnt++;
				}
			}
		}
		
		System.out.println(10-cnt);
		
		
		
		

	}

}
