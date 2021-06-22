package level1;

import java.util.*;

public class Solution_콜라츠추측 {
	
	public static void main(String[] args) {
		int n = 626331;
		int answer = solution(n);
		System.out.println(answer);
	}
	
	public static int solution(int num) {
        
        int cnt = 0;
        
        //num이 8000000미만 정수이므로 *3곱하면 int type벗어날 수 있다
        //long타입으로 해주어야함.... 요런거 신경쓰기
        long n = num;
        while(true) {
        	if(cnt==500) return -1;
        	if(n==1) break;
        	cnt++;
        	if(n%2==0) n /= 2;
            else {
            	n*=3;
            	n+=1;
            }
        	

        }
        
       return cnt;

    }

}