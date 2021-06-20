package level1;

public class Solution_로또의최고순위와최저순위 {
	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		int[] answer = solution(lottos, win_nums);
		
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {

		int[] answer = new int[2]; //int[0] : 최고순위, int[1] : 최저순위
		int[] rank = {6,6,5,4,3,2,1};
		int unknown =0 ;
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			
			int cur = lottos[i];

			if(cur==0) { //알수없는숫자이다.
				unknown++;
				continue;
			}
			
			for (int j = 0; j < 6; j++) {
				if(cur==win_nums[j]) {
					cnt++;
					break;
				}
			}
		}

		//최고로 많이 맞을 수 있는 숫자 : cnt+unknown
		//최저 숫자 : cnt
		answer[0] = rank[cnt+unknown];
		answer[1] = rank[cnt];
		
        return answer;
    }
}
