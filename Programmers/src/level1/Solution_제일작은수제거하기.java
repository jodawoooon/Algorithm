package level1;

import java.util.*;

public class Solution_제일작은수제거하기 {
	
	public static void main(String[] args) {
		int[] arr = {4,3,2,1};
		
		int[] answer = solution(arr);
		System.out.println(Arrays.toString(answer));
	}
	
    public static int[] solution(int []arr) {
  
    	if(arr.length==1) return new int[]{-1};
    	ArrayList<Integer> list = new ArrayList<>();
        
    	int min = Integer.MAX_VALUE;
    	for (int i : arr) {
			min = Math.min(i, min);
		}
    	
    	for (int i : arr) {
			if(min==i) continue;
			list.add(i);
		}
    	 
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
        		
    }
}