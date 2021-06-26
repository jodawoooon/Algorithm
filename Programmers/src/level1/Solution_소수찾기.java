package level1;

public class Solution_소수찾기 {
	public static void main(String[] args) {
		System.out.println(solution(10));
	}
	public static int solution(int n) {
		int answer = 0;
        
		for (int i = 2; i <= n; i++) {
			if(i==2) {
				answer++;
				continue;
			}
			
			if(i%2==0) continue;
			
			
			
			boolean flag = true;
			for (int j = 3; j <= (int)Math.sqrt(i); j+=2) {
				if(i%j==0) {
					flag = false;
					break;
				}
			}
			
			if(flag) answer++;
		}
        return answer;
    }
}
