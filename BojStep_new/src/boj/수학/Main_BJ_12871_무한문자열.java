package boj.수학;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_12871_무한문자열 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		
		if(s.length()!=t.length()) {
			int len = (s.length()*t.length())/gcd(s.length(),t.length());
			String resS = "";
			String resT = "";
			
			
			while(resS.length() != len) {
				resS += s;
			}
			
			while(resT.length() != len) {
				resT += t;
			}
			
			
			if(resS.equals(resT)) System.out.println(1);
			else System.out.println(0);
			
		}else {
			if(s.equals(t)) System.out.println(1);
			else System.out.println(0);
		}
	}

	private static int gcd(int a, int b) {
		while(b!=0) {
			int r = a;
			a =b;
			b = r%a;
		}
		return a;
	}

}
