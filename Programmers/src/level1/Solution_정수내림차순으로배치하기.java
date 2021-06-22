package level1;

import java.util.*;

public class Solution_정수내림차순으로배치하기 {
	
	public static void main(String[] args) {
		long n = 118372;
		long answer = solution(n);
		System.out.println(answer);
	}
	
	public static long solution(long n) {
        String ans = "";
        String num = Long.toString(n);
       
        Integer[] arr = new Integer[num.length()];
        for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(num.charAt(i)+"");
		}
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        for (int i : arr) {
			ans += i;
		}
        return Long.parseLong(ans);
    }

	public int solution(String s) {
	        if(s.charAt(0)=='-') return (0-Integer.parseInt(s));
	        else return Integer.parseInt(s);
	        
	    }
}