package level1;

import java.util.HashSet;

public class Solution_체육복_HashSet {
	public int solution(int n, int[] lost, int[] reserve) {
		
		//n 전체 학생의 수, lost 도난 학생 번호, reserve 여벌 학생 번호
		int answer = n;
		
		HashSet<Integer> reserveList = new HashSet<>();
		HashSet<Integer> lostList = new HashSet<>();
		
		for (int i : reserve) {
			reserveList.add(i);
		}
		for (int i : lost) {
			if(reserveList.contains(i)) {
				reserveList.remove(i);
			}else {
				lostList.add(i);
			}
		}
		
		for(Integer i : lostList) {
			if(reserveList.contains(i-1)) {
				reserveList.remove(i-1);
			}else if(reserveList.contains(i+1)) {
				reserveList.remove(i+1);
			}else { //빌릴수 없다. 학생수 감소
				answer--;
			}
		}
		
		
        
        return answer;
    }
}
