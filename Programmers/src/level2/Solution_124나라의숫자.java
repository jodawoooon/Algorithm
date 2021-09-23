package level2;

/**
 * 
 * 
 * ✨ Algorithm ✨
 * @Problem : Programmers 124 나라의 숫자 (3진법)
 * @Author : Daun JO
 * @Date : 2021. 9. 23. 
 *
 */
public class Solution_124나라의숫자 {
	 public String solution(int n) {
	        String answer = "";
	        
	        while(n>0){
	             if(n%3==1){
	                answer = "1"+answer;
	            }else if(n%3==2){
	                answer = "2"+answer;
	            }else if(n%3==0) {
	                answer = "4"+answer;
	                n--;
	            }
	            n/=3;
	        }
	        return answer;
	        
	    }
}
