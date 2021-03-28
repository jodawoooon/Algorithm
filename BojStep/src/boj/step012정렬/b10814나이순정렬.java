package boj.step012정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b10814나이순정렬 {
	static int N,ans;
	
	static String[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		
		//알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
		//길이가 짧은 것부터
		//길이가 같으면 사전 순으로
		arr = new String[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		
		Arrays.sort(arr, (a,b) -> {
			return Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));

	});
		
		for (int i = 0; i < N; i++) {
			bw.write(String.valueOf(arr[i][0])+" "+arr[i][1]+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
		
}
