package level1;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_같은숫자는싫어 {
	
	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		
		int[] answer = solution(arr);
		System.out.println(Arrays.toString(answer));
	}
	
    public static int[] solution(int []arr) {
  
        ArrayList<Integer> list = new ArrayList<>();
        
        int cur = -1;
        for (int i = 0; i < arr.length; i++) {
			int c = arr[i];
			if(c!=cur) {
				cur = c;
				list.add(c);
				continue;
			}
			while(true) {
				if(i>=arr.length) break;
				if(c!=arr[i]) {
					cur = arr[i];
					list.add(arr[i]);
					break;
				}
				i++;
			}
		}
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
        		
    }
}