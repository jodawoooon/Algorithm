package boj.step015그리디알고리즘;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11399ATM {
	static int N, K;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//동전개수를 최소한으로 만들고 싶다면. 일단 가장 큰 금액의 동전을 최대한 많이 사용한다.
		//각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하는 프로그램을 작성하시오.
		Arrays.sort(arr);
		int sum = arr[0];
		for (int i = 1; i < N; i++) {
			arr[i] = arr[i-1]+ arr[i];
			sum += arr[i];
		}
		
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		br.close();
		
	}
}
