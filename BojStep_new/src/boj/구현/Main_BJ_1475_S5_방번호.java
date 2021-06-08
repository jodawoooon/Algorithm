package boj.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1475_S5_방번호 {
	
//	
//	다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 
//	다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. 
//	(6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
//	
	static String N;
	static int ans;
	static int[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		
		check = new int[10]; //0~9까지의 체크 배열
		
		for (int i = 0; i < N.length(); i++) {
			int target = N.charAt(i)-'0';
			check[target]++;
		}
		
		if((check[6]+check[9])%2==0) { //바로 나누기2하는게아니라 홀,짝 구분
			int tmp = (check[6]+check[9])/2;
			
			check[6] = tmp;
			check[9] = tmp;
		}else {
			int tmp = (check[6]+check[9])/2+1;
			
			check[6] = tmp;
			check[9] = tmp;
		}
		
		
		for (int i = 0; i < 10; i++) {
			ans = Math.max(check[i], ans);
		}
		
		
		System.out.println(ans);
	}
}
