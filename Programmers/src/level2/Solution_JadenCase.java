package level2;

import java.util.*;

public class Solution_JadenCase {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        String first = s.charAt(0) + "";
        answer.append(first.toUpperCase());
        
        for(int i = 1 ; i < s.length() ; i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            if(curr==' ') answer.append(curr);
            else if(prev==' ') answer.append((curr+"").toUpperCase());
            else answer.append((curr+"").toLowerCase());
        }
        return answer.toString();
    }
}
