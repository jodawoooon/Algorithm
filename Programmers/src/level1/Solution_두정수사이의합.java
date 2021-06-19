package level1;

import java.util.*;

public class Solution_두정수사이의합 {
	
	public long solution(int a, int b) {
        long answer = 0;
        if(a==b) return a;
        
        for (long i = Math.min(a, b); i <= Math.max(a, b); i++) {
			answer += i;
		}
        return answer;
    }
}
