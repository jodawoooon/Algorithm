package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class sw4012요리사2 {
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
 
 
 
     
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("4012input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
 
            //초기화
            arr = new int[N][N];
            check = new boolean[N];
 
            min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            food(0, 0);
             
            System.out.println("#"+t+" "+min);
        }
    }
 
    private static void food(int idx, int start) {
        if(start>=N) return;
         
        if(idx==N/2) {
             
            List<Integer> tgt = new ArrayList<>();
            List<Integer> tgt2 = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if(check[i]) {
                    tgt.add(i);
                }else {
                    tgt2.add(i);
                }
            }
            int subSum1 = 0;
            int subSum2 = 0;
            for (int i = 0; i < tgt.size()-1; i++) {
                for (int j = i+1; j < tgt.size(); j++) {
                    subSum1 += arr[tgt.get(i)][tgt.get(j)];
                    subSum1 += arr[tgt.get(j)][tgt.get(i)];
                    subSum2 += arr[tgt2.get(i)][tgt2.get(j)];
                    subSum2 += arr[tgt2.get(j)][tgt2.get(i)];
                }
            }
             
            min = Math.min(min, Math.abs(subSum1-subSum2));
            return;
        }
         
         
        check[start] = true;
        food(idx+1, start+1);
        check[start] = false;
        food(idx, start+1);
    }
 
     
}