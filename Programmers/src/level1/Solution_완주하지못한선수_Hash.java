package level1;

import java.util.*;

public class Solution_완주하지못한선수_Hash {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        //participant : 참가자 이름
        //completion : 완주자 이름
        //참가자 중에는 동명이인이 있을 수 있습니다.
        //단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다. => 한명만 찾으면됨
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i < completion.length; i++) {
			if(!completion[i].equals(participant[i])) {
				return participant[i];
			}
		}
        
        return participant[participant.length-1];
    }
}
