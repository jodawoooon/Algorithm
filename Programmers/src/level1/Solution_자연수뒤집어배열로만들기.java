package level1;

import java.util.*;

public class Solution_자연수뒤집어배열로만들기 {
	
	public static void main(String[] args) {
		long n = 12345;
		int[] answer = solution(n);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(long n) {
        String num = Long.toString(n);
        
        int[] answer = new int[num.length()];
        for(int i=0;i<num.length();i++){
            answer[i] = Integer.parseInt(num.charAt(num.length()-i-1)+"");
        }
        return answer;
    }
}