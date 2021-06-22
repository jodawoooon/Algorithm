package level1;

import java.util.*;

public class Solution_하샤드수 {
	
	public static void main(String[] args) {
		int n = 13;
		boolean answer = solution(n);
		System.out.println(answer);
	}
	
	public static boolean solution(int x) {
		//하샤드 수 : x의 자릿수의 합으로 x가 나누어 진다.
		
		int sum = 0;
		String strNum = Integer.toString(x);
		for (int i = 0; i < strNum.length(); i++) {
			sum += Integer.parseInt(strNum.charAt(i)+"");
		}
		
		if(x%sum==0) return true;
		return false;
    }

}