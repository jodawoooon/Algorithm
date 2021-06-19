package level1;

public class Solution_약수의합 {
	public int solution(int n) {
        int ans = 0;
        
        for (int i = 1; i <= n; i++) {
			if(n%i==0) ans+=i;
		}
        return ans;
    }
}
