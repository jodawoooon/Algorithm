package level1;

public class Solution_소수만들기_comb {
	
	//주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
	static int answer;
	public int solution(int[] nums) {
        
        comb(0,0,nums,0);
        return answer;
    }

	private void comb(int idx, int start, int[] nums, int sum) {
		if(idx==3) {
			if(isPrime(sum)) {
				answer++;
			}
			return;
		}
		for (int k = start; k < nums.length; k++) {
			comb(idx+1, k+1, nums, sum+nums[k]);
		}
	}

	private boolean isPrime(int num) {
		boolean isP = true;
		
		for (int i = 2; i < num; i++) {
			if(num%i==0) {
				isP = false;
				break;
			}
		}
		return isP;
	}
}
