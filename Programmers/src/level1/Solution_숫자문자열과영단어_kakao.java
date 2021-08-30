package level1;

public class Solution_숫자문자열과영단어_kakao {
	
	static String[] numbers = {"zero", "one", "two", "three", "four", "five"
            ,"six", "seven", "eight", "nine"};
	
	public static void main(String[] args) {
		System.out.println(solution("2three45sixseven"));
	}
	
	
    static public int solution(String s) {
    	
        String answer = "";
        
        while(s.length()>0) {
        	boolean flag = false;
        	for(int i = 0 ; i < 10 ; i++) {
            	if(s.startsWith(numbers[i])) {
            		//해당 문자열의 맨 앞이 '문자'이다
            		answer += i;
            		s = s.substring(numbers[i].length());
            		flag = true;
            		break;
            	}
            }
        	
        	if(!flag) {
        		//해당 문자열의 맨 앞이 '숫자'이다
        		answer += s.charAt(0);
        		s = s.substring(1);
        	}
        }


        return Integer.parseInt(answer);
    }
	

}
