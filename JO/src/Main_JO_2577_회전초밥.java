

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_JO_2577_회전초밥 {
	static int N,d,k,c, ans, arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //접시의 수
		d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); //쿠폰번호
		
		
		//벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
		//행사참여시 쿠폰있으면 쿠폰번호 무료(벨트위에 없으면 만들어서 제공)
		int check[] = new int[3000001];

		arr = new int[N];

		
		//가능한 한 다양한 종류의 초밥을 먹으려고 한다
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());

		}
		

		
		check[c]++;
		int cnt = 1;
		
		
		for (int i = 0; i < k; i++) {
			check[arr[i]]++;
			if(check[arr[i]]==1)  cnt++;	
		}
		//처음에 0~k까지 탐색
		
		ans = cnt;

		//i번째 cnt지우고, k+i번째 cnt를 더한다. (그 사이의 값들은 그대로 유지)
		for (int i = 0; i < N-1; i++) {
			check[arr[i]]--;
			if(check[arr[i]]==0) cnt--;
			check[arr[(k+i)%N]]++;
			if(check[arr[(k+i)%N]]==1) cnt++;
			
			ans = Math.max(ans,cnt);
		}
		System.out.println(ans);
		
	}
}
