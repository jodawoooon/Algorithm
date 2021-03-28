package boj.step012정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2750수정렬하기_삽입 {
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

		int tmp = 0;
		int idx = 0;
		//삽입정렬은 i=1부터
		for (int i = 1; i < N; i++) {
			tmp = sort[i];
			idx = i;
			while(true) {
				if(idx<=0||tmp>=sort[idx-1]) break;
				
				//오름차순일때까지 반복
				sort[idx] = sort[idx-1];
				idx--;
			}
			sort[idx] = tmp;
			
		}
		for (int i = 0; i < N; i++) {
			System.out.println(sort[i]);
		}
		
	}
}
