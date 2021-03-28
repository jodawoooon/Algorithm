package boj.정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_BJ_1427_소트인사이드 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		Integer[] arr = new Integer[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i)-'0';
		}
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		});
		
		for (Integer integer : arr) {
			System.out.print(integer);
		}
	}
}
