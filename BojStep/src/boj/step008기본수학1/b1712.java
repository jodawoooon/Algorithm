package boj.step008기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1712 {
	static int BEP = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		System.out.println(A+" "+B+" "+C);
		
		//숫자로 접근
		// Cn > A + Bn
		// (C-B)n > a
		// n > a/(c-b)
		//(c-b)<=0이면 손익분기점은 없다
		
		while(true) {
			if(C<=B) {
				BEP=-1;
				break;
			}
			if(C*BEP>A+B*BEP) {
				break;
			}
			BEP++;
		}
		System.out.println(BEP);
		
	}
}
