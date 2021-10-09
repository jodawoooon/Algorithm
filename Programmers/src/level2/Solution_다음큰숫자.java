package level2;

import java.util.*;

public class Solution_다음큰숫자 {
	public int solution(int n) {
        int answer = n+1;
        int countOrgNum = getOneCount(Integer.toBinaryString(n));
            
        while(true){
            if(countOrgNum == getOneCount(Integer.toBinaryString(answer))) break;
            answer++;
        }
        
        return answer;
    }
    
    static int getOneCount(String num){
        int cnt = 0;
        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i)=='1') cnt++;
        }
        return cnt;
    }
}
