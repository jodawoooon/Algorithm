package boj.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2615_S3_오목 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int board[][] = new int[20][20];
        boolean visit[][][] = new boolean[20][20][4];
        
		for(int i=1; i<=19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=19; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
		}
        
        for(int i=1; i<=19; i++){
            for(int j=1; j<=19; j++){
                if(board[i][j] != 0){
                    int result = omokCheck(i, j, board, visit);
                    if(result == 0 || result == 1 || result == 2){
                        System.out.println(board[i][j]);
                        System.out.println((i) + " " + (j));
                        return;
                    }
                    else if(result == 3){
                        System.out.println(board[i][j]);
                        System.out.println((i+4) + " " + (j-4));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
	}
    
    private static int omokCheck(int r,int c, int board[][], boolean visit[][][]){
        int dir[][] = {{0,1},{1,0},{1,1},{1,-1}};
        for(int d=0; d<4; d++){
            if(visit[r][c][d] == false){
                boolean flag = false;
                visit[r][c][d] = true;
                int nr = r;
                int nc = c;
                int cnt = 1;
                while(true){
                    nr += dir[d][0];
                    nc += dir[d][1];
                    if(isBound(nr, nc) && board[nr][nc] == board[r][c]){
                        visit[nr][nc][d] = true;
                        cnt++;
                        continue;
                    }
                    break;
                }
                if(cnt == 5)
                    return d;
            }
        }
        
        return -1;
    }   
       
    private static boolean isBound(int r, int c){
        if(r <=0 || r> 19 || c <=0 || c>19 ){
            return false;
        }
        return true;
    }
}
