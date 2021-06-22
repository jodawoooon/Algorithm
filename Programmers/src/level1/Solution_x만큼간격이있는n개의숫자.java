package level1;

import java.util.*;

public class Solution_x만큼간격이있는n개의숫자 {
	
	public static void main(String[] args) {
		int x = 4;
		int n = 3;
		long[] answer = solution(x, n);
		System.out.println(Arrays.toString(answer));
	}
	
	public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        long sum = x;
        for (int i = 0; i < n; i++) {
        	
			answer[i] = sum;
			sum += x;
		}
        
        return answer;
    }

}