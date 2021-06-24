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
	        
			//i번째 숫자까지 자른다.
			for (int x = i-1; x < j; x++) {
				list.add(array[x]);
			}
			
			//정렬한다.
			Collections.sort(list);
			
			//k번째에 있는 수를 구한다.
			answer[c]=list.get(k-1);
		}
        return answer;
    }
}
