package boj.step012정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11650좌표정렬하기_시간초과 {
	static int N,ans;

	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//정렬. x좌표가 증가하는 순으로
		int tmpI = 0;
		int tmpJ = 0;
		int idx = 0;
		for (int i = 1; i < N; i++) {
			tmpI = arr[i][0];
			tmpJ = arr[i][1];
			idx = i;
			while(true) {
				if(idx<=0||tmpI>arr[idx-1][0]) break;
				if(tmpI==arr[idx-1][0]) {
					if(tmpJ<arr[idx-1][1]) {
						arr[idx][0] = arr[idx-1][0];
						arr[idx][1] = arr[idx-1][1];
						idx--;
					} break;
				}else {
					arr[idx][0] = arr[idx-1][0];
					arr[idx][1] = arr[idx-1][1];
					idx--;
				}
				
			}
			arr[idx][0] = tmpI;
			arr[idx][1] = tmpJ;
		}
		
		for (int i = 0; i < N; i++) {
			bw.write(String.valueOf(arr[i][0])+" "+String.valueOf(arr[i][1])+"\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}
	
		
}
