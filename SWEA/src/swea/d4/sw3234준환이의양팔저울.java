package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class sw3234준환이의양팔저울 {
	/*
	 * N개의 무게추를 양팔저울에 올리는 경우의 수.
	 * 단 오른쪽 무게의 총합이 왼쪽 무게의 총합보다 커지면 안된다.
	 * 
	 * 
	 */
	static int T, N, ans;

    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("3234input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
        	ans = 0;

        	N = Integer.parseInt(br.readLine()); 
            int[] arr = new int[N];

            boolean[] select = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

            comb(arr, select, 0,0,0);
 
            System.out.println("#"+t+" "+ans);
        }
    }
	private static void comb(int[] arr, boolean[] select, int cnt, int left, int right) {

		if(cnt==N) {
			ans++;
			return;
			
		}
		for (int i = 0; i < N; i++) {
			if(select[i]) continue;

			select[i] = true;
			comb(arr, select,cnt+1, left+arr[i], right);

			if(left>=right+arr[i]) {  //조건을 만족하면. right값을 증가시킨다.
				
				comb(arr, select,cnt+1, left, right+arr[i]);
			}
			
			select[i] = false;

		}
	}

     
}