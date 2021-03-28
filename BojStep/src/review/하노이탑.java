package review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class 하노이탑 {
	static int N,K;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		BigInteger bi = new BigInteger("2");
		BigInteger c = bi.pow(N).subtract(BigInteger.ONE);
		
		System.out.println(c);
		if(N<=20) {
			hanoi(N, 1, 3, 2);
			bw.write(sb.toString());
			bw.flush();
		}
		bw.flush();
		bw.close();
	}
	
	private static void hanoi(int n, int from, int to, int temp) {
		if(n==0) {

			return;
		}
		
		hanoi(n-1, from, temp, to);
		sb.append(from).append(" ").append(to).append("\n");
		hanoi(n-1, temp, to, from);
	}
}
