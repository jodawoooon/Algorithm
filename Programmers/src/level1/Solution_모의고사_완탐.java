package level1;

public class Solution_모의고사_완탐 {
	public int[] solution(int[] answers) {
        int[] answer;
        int[] stu1 = {1,2,3,4,5};
        int[] stu2 = {2,1,2,3,2,4,2,5};
        int[] stu3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] cnt = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
			if(answers[i] == stu1[i%5]) {
				cnt[0]++;
			}
			if(answers[i] == stu2[i%8]) {
				cnt[1]++;
			}
			if(answers[i] == stu3[i%10]) {
				cnt[2]++;
			}
		}
        int max = 0;
        
        for (int i = 0; i < cnt.length; i++) {
			max = Math.max(max, cnt[i]);
		}
        
        int idx = 0;
        for (int i = 0; i < cnt.length; i++) {
			if(cnt[i]==max) {
				idx++;
			}
		}
        
        answer = new int[idx];
        
        idx = 0;
        for (int i = 0; i < cnt.length; i++) {
			if(cnt[i]==max) {
				answer[idx++]=(i+1);
			}
		}
        
        return answer;
    }
}
