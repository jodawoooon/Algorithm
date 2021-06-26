package level1;

public class Solution_문자열내p와y의개수 {
	boolean solution(String s) {

        
        int pCnt = 0;
        int yCnt = 0;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='p') pCnt++;
			else if(c=='y') yCnt++;
		}

        if(pCnt==yCnt) return true;
        else return false;

    }
}
