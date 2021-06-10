package level1;

public class Solution_스킬체크테스트2 {
	//단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
	static String answer;
	public String solution(String s) {
		if(s.length()%2==0) {
			answer += s.charAt(s.length()/2-1);
			answer += s.charAt(s.length()/2);
		}else {
			answer += s.charAt(s.length()/2);
		}
        return answer;
    }
}
