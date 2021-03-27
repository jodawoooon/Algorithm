package boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_1244_스위치켜고끄기 {

	static int N,K,ans,sum;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
 
		arr = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		int stNum = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < stNum; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int gender = Integer.parseInt(st.nextToken());//성별
			int getNum = Integer.parseInt(st.nextToken());//받은수
			
			//1 켜짐 0 꺼짐
			//남학생이라면
			//스위치 번호가 자기가 받은 수의 배수이면. 그 스위치 상태 바꾼다
			if(gender==1) {
				for (int n = 1; n <= N; n++) {
					if(n%getNum==0) {
						if(arr[n]==1) arr[n]=0;
						else arr[n]=1;
					}
				}
				
			}else {
				//여학생이라면 받은 수와 같은 번호 스위치를 중심으로
				//좌우가 대칭이며 가장많은 스위치를 포함하는 구간 상태 모두 바꿈
	
				int cnt = 0;
				while(true) {
					int n1 = getNum+1*cnt;
					int n2 = getNum-1*cnt;
					
					if(n1>N||n2<1) break;
					
					if(arr[n1]==arr[n2]) {
						if(arr[n1]==1) {
							arr[n1]=0;
							arr[n2]=0;
						}else {
							arr[n1]=1;
							arr[n2]=1;
						}
						cnt++;
					}else {
						break;
					}
				}
			}
			
		}
		
		for (int i = 1; i <=N; i++) {
			if(i%20==0)System.out.println(arr[i]);
			else System.out.print(arr[i]+" ");
			
		}
		
	}
}
