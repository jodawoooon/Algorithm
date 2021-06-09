package level1;

public class Solution_체육복 {
	public int solution(int n, int[] lost, int[] reserve) {
		
		//n 전체 학생의 수, lost 도난 학생 번호, reserve 여벌 학생 번호
		if(lost.length==0) return n;
        int answer = n - lost.length;
        //체육수업을 들을 수 있는 학생의 최댓값
        
        for (int i = 0; i < lost.length; i++) {
        	for (int j = 0; j < reserve.length; j++) {
        		if(lost[i]==reserve[j]) {
        			answer++;
        			lost[i] = -1;
        			reserve[j] = -1;
        			break;
        		}
			}
		}
        
        for (int i = 0; i < lost.length; i++) {
        	if(lost[i]==-1) continue;
        	for (int j = 0; j < reserve.length; j++) {
        		if(reserve[j]==-1) continue;
				if(reserve[j]-1==lost[i]||reserve[j]+1==lost[i]) {
					answer++;
					reserve[j]=-1;
					break;
				}
			}
		}
        
        return answer;
    }
}
