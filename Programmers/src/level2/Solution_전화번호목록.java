package level2;

import java.util.*;

public class Solution_전화번호목록 {
	public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        int len = phone_book.length;
        
        for(int i=0 ; i < len -1 ; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        return true;
    }
}
