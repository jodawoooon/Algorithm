package level1;

public class Solution_약수의개수와덧셈 {

	public int solution(int left, int right) {
        int ans = 0;
        
        for (int i = left; i <= right; i++) {
			//약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return
        	
        	int cnt = getResult(i);
        	if(cnt%2==0) ans+=i;
        	else ans-=i;
		}
        return ans;
    }

	private static int getResult(int i) {
		int cnt = 0;
		for (int num = 1; num <= i; num++) {
			if(i%num==0) cnt++;
		}
		return cnt;
	}
}
