package level1;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_K번째수_정렬 {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int c = 0; c < commands.length; c++) {
        	int i = commands[c][0];
			int j = commands[c][1];
			int k = commands[c][2];
			
			ArrayList<Integer> list = new ArrayList<>();
	        
			for (int x = i-1; x < j; x++) {
				list.add(array[x]);
			}
			Collections.sort(list);
			answer[c]=list.get(k-1);
		}
        return answer;
    }
}
