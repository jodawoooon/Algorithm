package boj.a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14501_퇴사 {
	static int N, max;
	static int arr[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		max = 0;
		//N+1일째 되는날 퇴사
		//N일동안 최대한 많은 상담
		//상담완료기간 T와 금액P
		//최대 수익
		
		//동적계획법 -
		//앞으로의 모든 정보를 알고있다고 가정하고 최적 경로 찾기
		arr = new int[N+2][2];
		int[] profit = new int[N+1];
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[n][0] = Integer.parseInt(st.nextToken());
			arr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int n = N; n >= 1; n--) {
			if(n+arr[n][0] > N+1) {//잡혀있는 상담을 할수 없다면
				arr[n][1] = arr[n+1][1];//이익은
			}else {
				arr[n][1] = Math.max(arr[n+1][1], arr[n][1]+arr[n+arr[n][0]][1]);
				max = Math.max(max, arr[n][1]);
			}
		}
		
		System.out.println(max);
		
	}
	
}
