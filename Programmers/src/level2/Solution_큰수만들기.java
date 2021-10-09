package level2;
import java.util.*;

public class Solution_큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        stack.add(number.charAt(0)-'0');
        for(int i = 1 ; i < number.length(); i++){
            
            while(!stack.isEmpty()&&stack.peek()<number.charAt(i)-'0'&&k>0){
                stack.pop();
                k--;
            }
            stack.add(number.charAt(i)-'0');
        }
        
        if(k!=0){
            while(k>0){
                stack.pop();
                k--;
            }
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}