package boj.step012정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2750수정렬하기_버블 {
	static int N,ans;
	static int[] sort;
	//삽입정렬
	//정렬한 부분과 정렬하지 않은 부분을 나눈 후, 정렬할 대상을 정렬하지 않은 부분에서 차례대로 꺼내 비교하면서 삽입될 인덱스를 찾는다.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sort = new int[N];
		
		for (int i = 0; i < N; i++) {
			sort[i] = Integer.parseInt(br.readLine());
		}

		//버블정렬
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1-i; j++) {
				if(sort[j]>sort[j+1]){
					int tmp = sort[j];
					sort[j] = sort[j+1];
					sort[j+1] = tmp;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(sort[i]);
		}
		
	}
}
