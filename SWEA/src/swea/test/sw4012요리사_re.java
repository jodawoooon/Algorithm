package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sw4012요리사_re {

	public static int T, N, min;
    public static int[][] map;
    public static boolean[] select;
    
    public static int[] arrA;
	public static int[] arrB;
    
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("4012input.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 
        T = Integer.parseInt(br.readLine());
       
        
        for (int t = 1; t <=T; t++) {
        	N = Integer.parseInt(br.readLine());
        	
        	map = new int[N][N];
        	select = new boolean[N];
            arrA = new int[N/2];
            arrB = new int[N/2];
            
            for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
            
            min = Integer.MAX_VALUE;
            
            comb(0,0);
            System.out.println("#" + t + " " + min);
        }
    }
    
    private static void comb(int srcIdx, int tgtIdx) {
    	if(tgtIdx == N/2) {
    		
    		min = Math.min(min, check());
    		return;
    	}
    	
    	for (int i = srcIdx; i < N; i++) {
			select[i] = true;
			comb(i+1, tgtIdx+1);
			select[i] = false;
		}
    }

	private static int check() {
		int sumA = 0;
		int sumB = 0;
		
		int idxA = 0;
		int idxB = 0;
		
		for (int i = 0; i < N; i++) {
			if(select[i])arrA[idxA++] = i;
			else arrB[idxB++] = i;
		}
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				if(i!=j) {
					sumA += map[arrA[i]][arrA[j]];
					sumB += map[arrB[i]][arrB[j]];
				}
				

			}
		}
		
		return Math.abs(sumA-sumB);
	}
 
    
 
}