package boj.step012정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class b2751수정렬하기2 {
	static int N,ans;
	static ArrayList<Integer> sort;
	//삽입정렬
	//정렬한 부분과 정렬하지 않은 부분을 나눈 후, 정렬할 대상을 정렬하지 않은 부분에서 차례대로 꺼내 비교하면서 삽입될 인덱스를 찾는다.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		sort = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			sort.add(Integer.parseInt(br.readLine()));
			
		}
		
		Collections.sort(sort);
		
		for (int i = 0; i < N; i++) {
			bw.write(sort.get(i)+"\n");
			
		}
		bw.flush();
		bw.close();
	}
}
