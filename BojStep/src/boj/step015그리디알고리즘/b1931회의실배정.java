package boj.step015그리디알고리즘;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b1931회의실배정 {
	static int N, cnt;
	static int[][] arr;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i][1]);
		}
		 
		check = new boolean[max+1];
		//회의실 사용표 만들기
		//각 회의가 겹치지 않게 하면서 사용할 수 있는 최대 개수.
		//회의의 최대갯수.....  => 간격이 작은 애들부터 넣어볼까
		
		Arrays.sort(arr, (a,b) -> {
			if(a[1] == b[1]) {
				return Integer.compare(a[0], b[0]);
			}
			return Integer.compare(a[1], b[1]);
	});

		int end = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i][0]>=end){
				end = arr[i][1];
				cnt++;
			}

		}

		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
		
	}
}
