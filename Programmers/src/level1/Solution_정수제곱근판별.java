package level1;

public class Solution_정수제곱근판별 {
	public long solution(long n) {
        long answer = 0;
        for (long x = 1; x <= n; x++) {
			if(n==(x*x)) {
				return (x+1)*(x+1);
			}
		}
        return -1;
    }
}
