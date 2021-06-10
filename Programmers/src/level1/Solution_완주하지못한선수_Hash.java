package level1;

import java.util.*;

public class Solution_완주하지못한선수_Hash {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        //participant : 참가자 이름
        //completion : 완주자 이름
        //참가자 중에는 동명이인이 있을 수 있습니다.
        //단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다. => 한명만 찾으면됨
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
			if(map.get(p)==null) {
				map.put(p, 1);
			}else { //이름중복일경우
				map.put(p, map.get(p)+1);
			}
		}
        
        for (String p : completion) {
        	if(map.get(p)!=0) {
        		map.put(p, map.get(p)-1);
        	}
		}
        
        for (String key : map.keySet()) {
			if(map.get(key)!=0) {
				return key;
			}
		}
        
        return answer;
    }
}
