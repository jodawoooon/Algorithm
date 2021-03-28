package boj.step005;

import java.util.Scanner;

public class b1546 {
	public static void main(String[] args) {
		//1546 평균
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //시험 본 과목의 개수 <=1000
		int[] score = new int[N];
		for(int n=0;n<N;n++) {
			score[n] = sc.nextInt(); //현재 성적
		}
		/*
		 * 세준 점수 중 최댓값 = M
		 * 모든 점수는 점수/M*100
		 */
		
		int M = score[0];
		for (int i = 0; i < N; i++) {
			if(score[i]>M) {
				M = score[i];
			}
		}
		
		
		float sum = 0;
		for (int j = 0; j < N; j++) {
			sum += (float)score[j]/M*100;
			//score[j]/M을 소수형식으로 변환시켜줘야 한다. int형 나누기하면 0만 나옴
		}

		System.out.println(sum/N);

		
	}

}
