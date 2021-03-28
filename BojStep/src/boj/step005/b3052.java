package boj.step005;
import java.util.Scanner;

public class b3052 {

	public static void main(String[] args) {
		// 3052 나머지
		
		
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int[] arr = new int[10];
		for(int k=0;k<10;k++) {
			arr[k] = sc.nextInt()%42;
			
		}
		for(int i = 0;i<10;i++) {
			int same = 0;
			for(int j=i+1;j<10;j++) {
				if(arr[i]==arr[j]) {
					same++;
				} //중복포함 same이면 카운트

			}
			if(same==0) cnt++; //하나도 same이 없으면 cnt++한다. (서로 다른 값이라는 뜻)
		}
		System.out.println(cnt);

	}

}
