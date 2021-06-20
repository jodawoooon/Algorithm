package level1;

public class Solution_신규아이디추천_Kakao {
	public String solution(String new_id) {
        new_id = new_id.toLowerCase();

        String tmp = "";
        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for (int i = 0; i < new_id.length(); i++) {
        	char c = new_id.charAt(i);
			if((c>='a'&&c<='z')||c>='0'&&c<='9'||c=='-'||c=='_'||c=='.') {
				tmp += c;
			}
		}
        new_id = tmp;

        tmp = "";
        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        for (int i = 0; i < new_id.length(); i++) {
        	char c = new_id.charAt(i);
        	tmp += c;
			if(c=='.') {
				while(true) {
					if(i>=new_id.length()) break;
					
					if(new_id.charAt(i)!='.') {
						tmp += new_id.charAt(i);
						break;
					}
					i++;
				}
			}
        }
        new_id = tmp;

        tmp = "";
        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        for (int i = 0; i < new_id.length(); i++) {
        	char c = new_id.charAt(i);
        	if((i==0||i==new_id.length()-1)&&c=='.') continue;
        	tmp += c;
        }
        new_id = tmp;
        
        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(new_id.length()==0) new_id="a";
        
        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        else if(new_id.length()>=16) {
        	new_id = new_id.substring(0, 15);
        }

        
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(new_id.charAt(new_id.length()-1)=='.') {
        	new_id = new_id.substring(0, new_id.length()-1);
        }

        
        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(new_id.length()<=2) {
        	char c = new_id.charAt(new_id.length()-1);
        	while(true) {
        		if(new_id.length()==3) break;
        		new_id += c;
        	}
        }
        
        
        return new_id;
	}
}
