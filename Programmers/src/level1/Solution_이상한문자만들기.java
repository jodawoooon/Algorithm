package level1;

import java.util.*;

public class Solution_이상한문자만들기 {
	
	public static void main(String[] args) {
		String s = "try hello world";
		StringTokenizer st = new StringTokenizer(s.toUpperCase(), " ");
		String ans = "";
		while(st.hasMoreTokens()) {
			String[] str = st.nextToken().split("");
			for (int i = 1; i < str.length; i+=2) {
				str[i] = str[i].toLowerCase();
			}
	
			ans += String.join("", str); 
			ans += ",";

		}
		System.out.println(ans.replace(","," "));
	}

	
	public String solution(String s) {
		StringTokenizer st = new StringTokenizer(s.toUpperCase(), " ");
		String ans = "";
		while(st.hasMoreTokens()) {
			String[] str = st.nextToken().split("");
			for (int i = 1; i < str.length; i+=2) {
				str[i] = str[i].toLowerCase();
			}
	
			ans += String.join("", str); 
			ans += ",";

		}
		return ans.replace(",", " ");
    }
}
