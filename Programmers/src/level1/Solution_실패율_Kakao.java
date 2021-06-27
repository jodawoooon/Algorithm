package level1;

import java.util.*;

public class Solution_실패율_Kakao {
	public static void main(String[] args) {
		int N = 5;
		int[] stages = new int[] {2, 1, 2, 6, 2, 4, 3, 3};
		System.out.println(Arrays.toString(solution(N,stages)));
	}
	static class Info{
		int stage;
		double rate;
		public Info(int stage, double rate) {
			super();
			this.stage = stage;
			this.rate = rate;
		}
		
		
	}
	public static int[] solution(int N, int[] stages) {
        

        int[] answer = new int[N];
        ArrayList<Info> stageInfo = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
        	int passCnt = 0;
        	int userCnt = 0;
			for (int num : stages) {
				if(num>i) passCnt++;
				if(num>=i) userCnt++;
			}
			
			double rate = (double)(userCnt-passCnt)/(double)userCnt;

			stageInfo.add(new Info(i, rate));
		}
        
        Collections.sort(stageInfo, new Comparator<Info>() {

			@Override
			public int compare(Info o1, Info o2) {
				if(o1.rate<o2.rate) {
					return 1;
				}else if(o1.rate>o2.rate) {
					return -1;
				}return 0;
			}

	
        	
        });

        for (int i = 0; i < N; i++) {
			answer[i] = stageInfo.get(i).stage;

			
		}
        return answer;
    }
}
