package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기 {
	static int N, S;
	static int[] arr;
	public static void main(String[] args) throws Exception {

		//스위치상태 입력받고 학생을 뽑아서 자연수를 준다
		//남학생 -> 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다.(1->0, 0->1)
		//여학생 -> 스위치 번호를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서
		//그 구간의 스위치를 모두 바꿈(항상홀수)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		S = Integer.parseInt(br.readLine());
		for (int s = 0; s < S; s++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int G = Integer.parseInt(st2.nextToken());
			int gNum = Integer.parseInt(st2.nextToken());
			if(G==1) {
				//남학생일때
				for (int i = 1; i <= N; i++) {
					if(i%gNum==0) {
						if(arr[i]==1) arr[i]=0;
						else arr[i]=1;
					}
				}
			}else {
				//여학생일때
				int cnt = 0;

				while(true) {
					
					int ni1 = gNum - 1*cnt;
					int ni2 = gNum + 1*cnt;
					
					if(ni1>=1 && ni2<=N &&arr[ni1]==arr[ni2]) {
						if(arr[ni1]==1) {
							arr[ni1]=0;
							arr[ni2]=0;
						}
						else {
							arr[ni1]=1;
							arr[ni2]=1;
						}
						cnt++;
					}else {
						break;
					}
					
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(i%20==0) System.out.println(arr[i]);
			else System.out.print(arr[i]+" ");
			
		}
		
	}
}
