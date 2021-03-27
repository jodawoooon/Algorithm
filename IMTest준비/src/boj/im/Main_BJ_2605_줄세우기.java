package boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_2605_줄세우기 {
	
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list.add(0);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(i-num,i);
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}
