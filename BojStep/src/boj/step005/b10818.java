package boj.step005;
import java.util.Scanner;
public class b10818 {

	public static void main(String[] args) {
		// 10818 N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
			
		int max = arr[0];
		int min = arr[0];
		for(int i=0;i<N;i++) {
		
			if(arr[i]>max){
                max = arr[i];

            }
			if(arr[i]<min){
                min = arr[i];

            }
		}
		System.out.println(min+" "+max);

	}

}
