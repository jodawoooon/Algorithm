package level1;

import java.util.*;

public class Solution_문자열을정수로바꾸기 {
	
	public static void main(String[] args) {
		String n = "-1234";
		int answer = solution(n);
		System.out.println(answer);
	}
	
	public static int solution(String s) {
         return Integer.parseInt(s);
        
    }

}