package level1;

import java.util.*;

public class Solution_나누어떨어지는숫자배열 {
	public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i : arr) {
			if(i%divisor==0) list.add(i);
		}
        
        if(list.size()==0) return new int[] {-1};
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}
