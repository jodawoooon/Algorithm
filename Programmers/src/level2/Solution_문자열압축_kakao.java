package level2;

public class Solution_문자열압축_kakao {
	
	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
	}
	
	static public int solution(String s) {
        int answer = s.length();
        
       
        for(int i = 1; i <= s.length()/2 ; i++) {

        	String res = "";
        	String prev = s.substring(0, i);
        	int cnt = 1;
        	int idx = i;
        	
        	while(idx<=s.length()) {

        		String word = "";
        		
        		if(idx+i>=s.length()) word = s.substring(idx);
        		else word =s.substring(idx, idx+i);

            	if(prev.equals(word)) cnt++;
            	else {
            		if(cnt>1) {
            			res += cnt;
            		}
            		
            		res += prev;
            		
            		prev = word;
            		cnt = 1;
            	}
            	idx += i;
        	}
        	
        	res += prev;
        	answer = Math.min(answer, res.length());
        }
   
        return answer;
    }
}
