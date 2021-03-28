package boj.step012정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class b1427소트인사이드 {
	static int N,ans;

	static Integer[] arr;
	static Integer[] sort;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		arr = new Integer[str.length()];
		int length = arr.length;
		
		for (int i = 0; i < length; i++) {
			arr[i] = str.charAt(i)-'0';
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		for (int n : arr) {
			bw.write(String.valueOf(n));
		}
		bw.flush();
		bw.close();
		br.close();

	}
	
		
}
