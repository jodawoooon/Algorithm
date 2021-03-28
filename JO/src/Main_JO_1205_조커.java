

import java.io.*;
import java.util.*;


public class Main_JO_1205_조커 {
	
	static int N, joker, ans;
	static int[] arr;
	//조커는 카운팅을 해서 필요한 곳에 적절하게 사용
	//조커 카드, 일반카드 주어졌을때 가장 긴 길이의 스트레이트 만들어라
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		int idx = 0;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int n = 0; n < N; n++) {
			//중복 값 제거하고, 정렬. 조커는 어떤 숫자로든 변환 가능..
			int tmp = Integer.parseInt(st.nextToken());
				arr[n] = tmp;
			if(tmp==0) joker++;
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
		if(joker==N) {
			System.out.println(joker);
		}else {
			int max = 0;
			for (int i = joker; i < N-1; i++) {
				int jok = joker;
				int length = 1;
				int val = arr[i];
				for (int j = i+1;j<N; j++) {
					if(arr[j]-val==0) {
						continue;
					}
					if(arr[j]-val<=jok+1) {
						int diff = arr[j]-val-1;
						jok -= diff;

						
						length += diff+1;
						val = arr[j];
						//조커가 없으면 멈춘다
					}else {
						
						break;
					}
					
				}
				ans = Math.max(ans, length+jok);
				
			}
			System.out.println(ans);
		}

	}
}
