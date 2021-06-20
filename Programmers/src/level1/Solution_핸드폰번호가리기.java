package level1;

import java.util.*;

public class Solution_핸드폰번호가리기 {
	
	public String solution(String phone_number) {
        String answer = "";
        for (int i = 0; i < phone_number.length()-4; i++) {
			answer+="*";
		}
        answer += phone_number.substring(phone_number.length()-4);;
        return answer;
    }
}
