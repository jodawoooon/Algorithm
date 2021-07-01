package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003_수들의합2 {
	public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
	
        int[] arr = new int[n];
        
        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int cnt = 0;
        int end = 0;
        
        for(int start=0; start<n; start++) {
        	while(sum<m&&end<n) {
        		sum += arr[end];
        		end++;
        	}
        	//현재 부분의 합이 M보다 작다면, end가 가리키는 값을 sum에 더하고 end를 1 증가시킨다.
        	
        	if(sum==m) cnt++;
        	//현재 부분의 합이 M과 같다면, 카운트한다.
        	sum -= arr[start];
        	//현재 부분의 합이 M보다 크다면, start가 가리키는 값을 sum에서 빼고 start를 1 증가시킨다.
        }
        
        //이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수
        System.out.println(cnt);
	
	}
}
