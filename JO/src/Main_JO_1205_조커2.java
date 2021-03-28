
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_JO_1205_조커2 {
	
	static int N, jokerCnt, ans;
	static boolean[] check;
	static ArrayList<Integer> arr;
	//조커는 카운팅을 해서 필요한 곳에 적절하게 사용
	//조커 카드, 일반카드 주어졌을때 가장 긴 길이의 스트레이트 만들어라
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList<>();
		check = new boolean[1000001];
		check[0] = true;
		int idx = 0;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int n = 0; n < N; n++) {
			//중복 값 제거하고, 정렬. 조커는 어떤 숫자로든 변환 가능..
			int tmp = Integer.parseInt(st.nextToken());
			if(!check[tmp]) {
				check[tmp]=true;
				arr.add(tmp);
			}
			if(tmp==0) jokerCnt++;
		}
		
		Collections.sort(arr);
		boolean flag = true;
		
		
		for (int i = 1; i < arr.size(); i++) {
			int joker = jokerCnt;
			int length = 1;
			int sub = arr.get(i)-arr.get(i-1);
			if(sub==1) {
				length++;

			}else if(sub<joker){
				length+=sub;
				joker-=sub;
				continue;
			}
			ans = Math.max(ans, length+joker);

		}
		System.out.println(ans);
	}
}
