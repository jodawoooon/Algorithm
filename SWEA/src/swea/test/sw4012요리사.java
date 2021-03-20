package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sw4012요리사 {
	/*
	 * 두 명에게 음식 제공
	 * N개의 식재료
	 * 식재료를 N/2개씩 나누어 두개의 요리를 한다 (N은 짝수)
	 * A음식 B음식의 맛의 차이가 최소가 되도록 재료를 배분해야 한다. 
	 * 식재료 i와 j의 시너지에 따라 맛이 결정된다.
	 * 
	 * 두 음식간의 맛의 차이가 최소가 되는 경우를 찾고, 그 최솟값을 정답으로 출력하라
	 * 
	 * 
	 */
	static int T, N,  min;
	 
    static boolean check[];
    static int[][] arr;
    static int[] tgt, tgt2, tmp;
 
 
     
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("4012input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
 
            //초기화
            arr = new int[N+1][N+1];
            check = new boolean[N+1];
            tgt = new int[N/2];
            tgt2 = new int[N/2];
            tmp = new int[2];
            min = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            food(0, 1);
             
            System.out.println("#"+t+" "+min);
        }
    }
 
    private static void food(int idx, int start) {
        if(idx==N/2) {
             
            //tgt에 담긴 음식들의 모든 시너지합을 구한다
            //=> 순열으로 시너지 순서 구함
            int tgt2Idx = 0;
            for (int i = 1; i <= N; i++) {
                if(!check[i]) {
                    tgt2[tgt2Idx] = i;
                    tgt2Idx++;
                }
            }
             
 
            int res = solve();
            min = Math.min(min, res);
            return;
        }
         
        for (int i = start; i <= N; i++) {
            check[i] = true;
            tgt[idx] = i;
            food(idx+1, i+1);
            check[i] = false;
        }
    }
 
    private static int solve() {
        int subSum1 = 0;
        int subSum2 = 0;
        for (int i = 0; i < N/2-1; i++) {
            for (int j = i; j < N/2; j++) {
                subSum1 += arr[tgt[i]][tgt[j]];
                subSum1 += arr[tgt[j]][tgt[i]];
                subSum2 += arr[tgt2[i]][tgt2[j]];
                subSum2 += arr[tgt2[j]][tgt2[i]];
            }
        }
         
        return Math.abs(subSum1-subSum2);
    }
 
     
}