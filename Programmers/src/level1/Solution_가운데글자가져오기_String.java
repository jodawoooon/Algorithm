package level1;

public class Solution_가운데글자가져오기_String {
	//단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
	
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		
		if(s.length()%2==0) {
			sb.append(s.charAt(s.length()/2-1));
			sb.append(s.charAt(s.length()/2));
		}else {
			sb.append(s.charAt(s.length()/2));
		}
        return sb.toString();
    }
}
