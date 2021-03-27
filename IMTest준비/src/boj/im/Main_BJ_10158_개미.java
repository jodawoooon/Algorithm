package boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10158_개미 {
	
	
	//처음에 우상, 좌상, 좌하, 우하

	static int W, H, T;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		T = Integer.parseInt(br.readLine());

		int dir = 0;
		int nw = p;
		int nh = q;
		boolean flagI = true;
		boolean flagJ = true;
		while(true) {
			if(T==0) {
				System.out.println(nw+" "+nh);
				break;
			}
			
			if(nw>=W) {
				flagI= false;
				
			}else if(nw==0){
				flagI = true;
			}
			
			
			if(nh>=H) {
				flagJ = false;
			}else if(nh==0) {
				flagJ = true;
			}
			
			if(nw<W&&flagI==true) {
				nw++;
				
			}else {
				nw--;
			}
			
			
			if(nw<H&&flagJ==true) {
				nh++;
			}else {
				nh--;
			}
			T--;
			
		}
		
	}
}
