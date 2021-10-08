package level2;

import java.util.Arrays;

public class Solution_N개의최대공배수 {
	public int solution(int[] arr) {
        
        Arrays.sort(arr);
        int answer = arr[0];
        
        for(int i=1; i<arr.length; i++) answer = lcm(answer, arr[i]);
        
        return answer;
    }
    
    //최대공약수
    static int gcd(int a, int b){
        while(b>0){
            int r = a%b;
            a = b;
            b = r;
        }
        
        return a; //a,b의 최대공약수
    }
    
    //최대 공배수 = a*b/최대공약수
    static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}
}
