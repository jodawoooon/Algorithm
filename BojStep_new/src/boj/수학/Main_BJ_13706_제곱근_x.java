package boj.수학;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_13706_제곱근_x {
	
	static int N;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		long ans = Math.round(Math.sqrt(N));
		System.out.println(ans);
	}
}
