package level1;

public class Solution_서울에서김서방찾기 {
	public String solution(String[] seoul) {
        String answer = "김서방은 ";
        
        for (int i = 0; i < seoul.length; i++) {
			if(seoul[i].equals("Kim")) answer+=i;
		}
        return answer+"에 있다";
    }
}
